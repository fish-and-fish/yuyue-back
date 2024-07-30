package com.amrni.sport.shop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrni.sport.shop.command.BaseIdCmd;
import com.amrni.sport.shop.command.BookingCmd;
import com.amrni.sport.shop.command.LoginCmd;
import com.amrni.sport.shop.common.ApiResponse;
import com.amrni.sport.shop.common.Stream2Utils;
import com.amrni.sport.shop.model.Booking;
import com.amrni.sport.shop.model.Course;
import com.amrni.sport.shop.model.Teacher;
import com.amrni.sport.shop.model.User;
import com.amrni.sport.shop.service.CourseService;
import com.amrni.sport.shop.vo.BookingInfoVo;
import com.amrni.sport.shop.vo.UserVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/login")
    public ApiResponse<UserVo> login(@RequestBody LoginCmd loginCmd) throws IOException {
        UserVo user1 = courseService.login(loginCmd);
        return new ApiResponse<>(user1, true, "success");
    }

    @GetMapping("/all")
    public ApiResponse<List<Course>> getAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        return new ApiResponse<>(courses, true, "成功获取课程列表");
    }

    @GetMapping("/all/teacher")
    public ApiResponse<List<Teacher>> getAllTeacher(@RequestParam Integer courseId) {
        List<Teacher> list = courseService.findAllTeacher(courseId);
        return new ApiResponse<>(list, true, "成功获取课程列表");
    }

    @PostMapping("/book")
    public ApiResponse<String> book(User user,
                                    @RequestBody BookingCmd bookingCmd) {
        return new ApiResponse<>(courseService.booking(user, bookingCmd), true, "成功获取课程列表");
    }

    @PostMapping("/book/cancel")
    public ApiResponse<String> bookCancel(User user,
                                          @RequestBody BaseIdCmd baseIdCmd) {
        return new ApiResponse<>(courseService.bookCancel(user, baseIdCmd.getId()), true, "成功获取课程列表");
    }

    @PostMapping("/book/info")
    public ApiResponse<BookingInfoVo> bookInfo(User user) {
        return new ApiResponse<>(courseService.bookInfo(user), true, "成功获取课程列表");
    }

    @GetMapping("/book/list")
    public ApiResponse<List<Booking>> bookList(User user,
                                               @RequestParam String status) {
        return new ApiResponse<>(courseService.bookList(user, status), true, "成功获取课程列表");
    }
}