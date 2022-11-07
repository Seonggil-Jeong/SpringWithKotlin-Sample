package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {
    companion object : KLogging()

    @PostMapping
    fun addCourse(@RequestBody @Validated courseDTO: CourseDTO): ResponseEntity<CourseDTO> {
        logger.info("addCourse Start!")

        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDTO))
    }
}