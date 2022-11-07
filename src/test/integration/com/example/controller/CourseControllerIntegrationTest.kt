package com.example.controller

import com.example.dto.CourseDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @DisplayName("Create Course Test")
    fun addCourse() {
        val name = "name"
        val category = "category"
        val request = CourseDTO(null, name, category)

        // when
        val result = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(request)
            .exchange()

            .expectStatus().isCreated // status code
            .expectBody(CourseDTO::class.java) // body Type
            .returnResult().responseBody

        Assertions.assertTrue {
            result!!.id != null // result is Not Null And id too
            result.name == name
            result.category == category
        }


    }
}