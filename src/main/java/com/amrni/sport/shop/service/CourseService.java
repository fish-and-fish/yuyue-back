package com.amrni.sport.shop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amrni.sport.shop.command.BookingCmd;
import com.amrni.sport.shop.common.Stream2Utils;
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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService  {

    private final CourseJpa courseJpa;
    private final TeacherJpa teacherJpa;
    private final UserJpa userJpa;
    private final BookingJpa bookingJpa;
    private final CourseTeacherJpa courseteacherJpa;

    public static final String BOOKING = "BOOKING";
    public static final String COMPLETE = "COMPLETE";
    public static final String CANCEL = "CANCEL";

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
        Booking booking = new Booking();
        booking.setUserId(user.getId());
        booking.setCourseId(bookingCmd.getCourseId());
        booking.setTeacherId(bookingCmd.getTeacherId());
        booking.setBookingStartTime(bookingCmd.getStartTime());
        booking.setBookingEndTime(bookingCmd.getEndTime());
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookStatus(BOOKING);
        bookingJpa.save(booking);
        return "预约成功";
    }

    public List<Booking> bookList(User user) {
        List<Booking> list = bookingJpa.findByUserIdAndBookStatus(user.getId(), BOOKING);

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
}

