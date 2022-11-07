package com.example.service

import com.example.dto.CourseDTO

interface CourseService {

    fun addCourse(courseDTO: CourseDTO) : CourseDTO

}