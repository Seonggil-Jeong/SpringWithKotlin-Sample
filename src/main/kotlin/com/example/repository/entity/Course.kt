package com.example.repository.entity

import javax.persistence.*

@Entity
@Table(name = "COURSES")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int?,
    val name: String,
    val category: String

)