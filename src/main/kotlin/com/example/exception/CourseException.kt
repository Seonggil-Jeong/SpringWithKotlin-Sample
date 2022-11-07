package com.example.exception

import com.example.exception.result.CourseExceptionResult
import java.lang.RuntimeException

class CourseException(val errorResult: CourseExceptionResult) : RuntimeException() {
}