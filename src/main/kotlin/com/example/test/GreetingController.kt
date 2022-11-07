package com.example.test

import com.example.dto.CourseDTO
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/test")
class GreetingController(val greetingService: GreetingService) {

    companion object : KLogging() // for logging


    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable name: String): ResponseEntity<String> {

        logger.info(this.javaClass.name + "Start retrieveGreeting !")

        return ResponseEntity.ok().body(greetingService.retrieveGreeting(name))
    }
}