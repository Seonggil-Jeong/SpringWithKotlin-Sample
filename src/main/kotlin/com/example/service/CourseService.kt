package com.example.service

import com.example.dto.CourseDTO

interface CourseService {

    fun addCourse(courseDTO: CourseDTO): CourseDTO

    fun findAllCourse(): List<CourseDTO>
    fun findCourseByCourseId(courseId: Int): CourseDTO

    fun updateCourse(courseId: Int, request: CourseDTO): CourseDTO

    fun deleteCourse(courseId: Int)

}