package com.example.service.impl

import com.example.dto.CourseDTO
import com.example.exception.CourseException
import com.example.exception.result.CourseExceptionResult
import com.example.repository.CourseRepository
import com.example.repository.entity.Course
import com.example.service.CourseService
import mu.KLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
class CourseServiceImpl(val courseRepository: CourseRepository) : CourseService {

    companion object : KLogging()

    @Transactional(rollbackFor = [Exception::class])
    override fun addCourse(courseDTO: CourseDTO) = courseRepository.save(courseDTO.let {
        Course(_id = null, _name = it.name, _category = it.category)
    }).let { entity -> // entity --> DTO
        CourseDTO(id = entity.id, name = entity.name, category = entity.category)
    }

    override fun findAllCourse(): List<CourseDTO> {
        return courseRepository.findAll()
            .map {
                CourseDTO(it.id, it.name, it.category)
            }
    }

    override fun findCourseByCourseId(courseId: Int): CourseDTO {
        val result: Course = courseRepository.findByIdOrNull(courseId)
            ?: throw CourseException(CourseExceptionResult.COURSE_NOT_FOUND)

        return CourseDTO(result.id, result.name, result.category)
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun updateCourse(courseId: Int, request: CourseDTO): CourseDTO {
        val result = courseRepository.findByIdOrNull(courseId)
            ?: throw CourseException(CourseExceptionResult.COURSE_NOT_FOUND)

        return courseRepository.save(Course(result.id, request.name, request.category)).let {
            CourseDTO(it.id, it.name, it.category)
        }

    }

    @Transactional(rollbackFor = [Exception::class])
    override fun deleteCourse(courseId: Int) = courseId.run {
        logger.info("delete Course Id : $this")
        courseRepository.deleteById(this)
    }
}