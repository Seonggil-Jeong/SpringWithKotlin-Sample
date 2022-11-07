package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringWithKotlinSampleApplication

fun main(args: Array<String>) {
	runApplication<SpringWithKotlinSampleApplication>(*args)
}
