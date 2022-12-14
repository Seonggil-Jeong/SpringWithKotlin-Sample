package com.example.controller

import com.example.dto.CourseDTO
import com.example.service.CourseService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class CourseController(val courseService: CourseService) {
    companion object : KLogging()

    @PostMapping("/courses")
    fun addCourse(@Valid @RequestBody courseDTO: CourseDTO): ResponseEntity<CourseDTO> {
        logger.info("addCourse Start!")


        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDTO))
    }

    @GetMapping("/courses")
    fun findAllCourses(): ResponseEntity<List<CourseDTO>> = ResponseEntity.ok().body(courseService.findAllCourse())


    @GetMapping("/courses/{courseId}")
    fun findCourse(@PathVariable courseId: Int) = ResponseEntity.ok().body(courseService.findCourseByCourseId(courseId))

    @PutMapping("/courses/{courseId}")
    fun updateCourse( /// Kotlin Param 은 항상 불변
        @Valid @RequestBody courseDTO: CourseDTO, @PathVariable courseId: Int): ResponseEntity<CourseDTO>
    = ResponseEntity.ok().body(courseService.updateCourse(courseId, courseDTO))


    @DeleteMapping("/courses/{courseId}")
    fun deleteCourse(@PathVariable courseId: Int) : ResponseEntity<Any>
    = ResponseEntity.ok().body(courseService.deleteCourse(courseId))

}