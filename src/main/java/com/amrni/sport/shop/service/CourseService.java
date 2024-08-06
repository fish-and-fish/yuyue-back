package com.amrni.sport.shop.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amrni.sport.shop.command.BookingCmd;
import com.amrni.sport.shop.command.JwtUtil;
import com.amrni.sport.shop.command.LoginCmd;
import com.amrni.sport.shop.command.OkHttpUtil;
import com.amrni.sport.shop.common.Properties;
import com.amrni.sport.shop.common.Stream2Utils;
import com.amrni.sport.shop.exception.MyRuntimeException;
import com.amrni.sport.shop.jpa.BookingJpa;
import com.amrni.sport.shop.jpa.CourseJpa;
import com.amrni.sport.shop.jpa.CourseTeacherJpa;
import com.amrni.sport.shop.jpa.TeacherJpa;
import com.amrni.sport.shop.jpa.UserJpa;
import com.amrni.sport.shop.model.Booking;
import com.amrni.sport.shop.model.Course;
import com.amrni.sport.shop.model.CourseTeacher;
import com.amrni.sport.shop.model.Teacher;
import com.amrni.sport.shop.model.User;
import com.amrni.sport.shop.vo.BookingInfoVo;
import com.amrni.sport.shop.vo.UserVo;
import com.google.common.collect.Maps;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseJpa courseJpa;
    private final TeacherJpa teacherJpa;
    private final UserJpa userJpa;
    private final BookingJpa bookingJpa;
    private final CourseTeacherJpa courseteacherJpa;

    public List<Course> findAllCourses() {
        return courseJpa.findAll();
    }

    public List<Teacher> findAllTeacher(Integer courseId) {
        List<CourseTeacher> allByCourseId = courseteacherJpa.findAllByCourseId(courseId);
        List<Integer> teacherIdList = Stream2Utils.map(allByCourseId, CourseTeacher::getTeacherId);
        List<Teacher> allById = teacherJpa.findAllById(teacherIdList);
        return allById;
    }

    public String booking(User user, BookingCmd bookingCmd) {
        if(bookingCmd.getEndTime().isBefore(LocalDateTime.now())){
            throw new MyRuntimeException("不能预约当前时间之前的时间段");
        }
        Booking booking = new Booking();
        booking.setUserId(user.getId());
        booking.setCourseId(bookingCmd.getCourseId());
        booking.setTeacherId(bookingCmd.getTeacherId());
        booking.setBookingStartTime(bookingCmd.getStartTime());
        booking.setBookingEndTime(bookingCmd.getEndTime());
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookStatus(Booking.BOOKING);
        bookingJpa.save(booking);
        return "预约成功";
    }

    public List<Booking> bookList(User user, String status) {
        List<Booking> list = bookingJpa.findByUserIdAndBookStatus(user.getId(), status);

        List<Integer> courseIdList = Stream2Utils.map(list, Booking::getCourseId);
        List<Integer> teacherIdList = Stream2Utils.map(list, Booking::getTeacherId);

        List<Course> courseList = courseJpa.findAllById(courseIdList);
        List<Teacher> teacherList = teacherJpa.findAllById(teacherIdList);

        Map<Integer, Course> integerCourseMap = Stream2Utils.toMap(courseList, Course::getId);
        Map<Integer, Teacher> integerTeacherMap = Stream2Utils.toMap(teacherList, Teacher::getId);

        for (Booking booking : list) {
            booking.setCourse(integerCourseMap.get(booking.getCourseId()));
            booking.setTeacher(integerTeacherMap.get(booking.getTeacherId()));
        }

        return list;
    }

    public String bookCancel(User user, Integer id) {
        Booking booking = bookingJpa.findByUserIdAndId(user.getId(), id);

        if (booking == null) {
            return "预约不存在";
        }
        booking.cancel();
        bookingJpa.save(booking);
        return "取消成功";
    }

    public BookingInfoVo bookInfo(User user) {
        Integer id = user.getId();
        int bookingNum = bookingJpa.findByUserIdAndBookStatus(id, Booking.BOOKING).size();
        int completeNum = bookingJpa.findByUserIdAndBookStatus(id, Booking.COMPLETE).size();
        BookingInfoVo bookingInfoVo = new BookingInfoVo();
        bookingInfoVo.setBookingCourseNum(bookingNum);
        bookingInfoVo.setFinishCourseNum(completeNum);
        bookingInfoVo.setVip(true);
        bookingInfoVo.setExpiredTime(LocalDateTime.now().plusDays(30));
        return bookingInfoVo;
    }

    public UserVo login(LoginCmd loginCmd) throws IOException {

        Map<String, String> params = Maps.newHashMap();
        params.put("appid", Properties.appid);
        params.put("secret", Properties.secret);
        params.put("js_code", loginCmd.getCode());
        params.put("grant_type", "authorization_code");

        String response = OkHttpUtil.sendGetRequest("https://api.weixin.qq.com/sns/jscode2session", params);

        Map map = JSONUtil.toBean(response, Map.class);
        String openid = map.get("openid").toString();

        User user = userJpa.findByOpenid(openid);
        if (user == null) {
            user = new User();
            user.setOpenid(openid);
            user.setUnionid("");
            user = userJpa.save(user);
        }

        String s = JwtUtil.generateToken(user.getId().toString());
        UserVo userVo = new UserVo();
        userVo.setToken(s);
        return userVo;
    }
}

