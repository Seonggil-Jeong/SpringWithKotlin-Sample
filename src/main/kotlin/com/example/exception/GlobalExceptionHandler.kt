package com.example.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(CourseException::class) // handle CourseException
    fun handleCourseException(exception: CourseException): ResponseEntity<ErrorResponse> {

        logger.error("CourseException occur : $exception")

        return ResponseEntity.status(exception.errorResult.httpStatus)
            .body(ErrorResponse(exception.errorResult.name, exception.errorResult.message))


    }


    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult.allErrors
            .map { error -> error.defaultMessage!! }
            .sorted()

        logger.error("Validation Exception occur : $ex")

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse("VALIDATION_FAILED", errors[0]))
    }

    data class ErrorResponse(
        val code: String,
        val message: String
    )

}