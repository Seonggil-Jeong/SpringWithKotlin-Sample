package com.example.dto

import javax.validation.constraints.NotNull

data class CourseDTO(
    val id: Int?, // can be null
    @field:NotNull(message = "name must not be null")
    val name: String,
    @field:NotNull(message = "category must not be null")
    val category: String,
    )