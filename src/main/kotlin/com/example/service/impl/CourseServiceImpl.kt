package com.example.service.impl

import com.example.dto.CourseDTO
import com.example.repository.CourseRepository
import com.example.repository.entity.Course
import com.example.service.CourseService
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(val courseRepository: CourseRepository) : CourseService {

    companion object : KLogging()

    override fun addCourse(courseDTO: CourseDTO) = courseRepository.save(courseDTO.let {
        Course(id = null, name = it.name, category = it.category)
    }).let {entity -> // entity --> DTO
            CourseDTO(id = entity.id, name = entity.name, category = entity.category)
        }


}