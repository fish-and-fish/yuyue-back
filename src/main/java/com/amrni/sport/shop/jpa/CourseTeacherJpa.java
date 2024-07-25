package com.amrni.sport.shop.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrni.sport.shop.model.CourseTeacher;

public interface CourseTeacherJpa extends JpaRepository<CourseTeacher, Integer> {

    List<CourseTeacher> findAllByCourseId(Integer courseId);
}

