package com.example.exception.result

import org.springframework.http.HttpStatus

enum class CourseExceptionResult(val httpStatus: HttpStatus, val message: String) {
    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "course not found")


}