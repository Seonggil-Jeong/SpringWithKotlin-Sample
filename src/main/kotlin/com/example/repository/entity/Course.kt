package com.example.repository.entity

import javax.persistence.*

@Entity
@Table(name = "COURSES")
open class Course(
    var _id : Int? = null,
    var _name: String,
    var _category: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String = _name
    var category: String = _category

    protected set // don't use
}