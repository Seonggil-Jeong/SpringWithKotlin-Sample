package com.example.dto

import javax.validation.constraints.NotNull

data class CourseDTO(
    val id: Int?, // can be null
    val name: String,
    val category: String,
    )