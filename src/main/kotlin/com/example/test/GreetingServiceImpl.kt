package com.example.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingServiceImpl : GreetingService {

    /**
     * lateinit는 var로 선언한 프로퍼티에만 사용할 수 있다
     * lateinit는 클래스 몸체, Top-Level, 함수 내부에 선언한 프로퍼티에 사용할 수 있다. 주 생성자에서는 사용할 수 없다
     * lateinit는 사용자 정의 getter/setter를 사용하지 않은 프로퍼티에만 사용할 수 있다
     * null 허용 프로퍼티에는 사용할 수 없다
     * 기초 타입 프로퍼티에는 사용할 수 없다
     */
    @Value("\${message}")
    lateinit var message: String

    override fun retrieveGreeting(name: String): String = "$message $name"

}