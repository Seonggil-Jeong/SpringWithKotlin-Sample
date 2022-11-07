package com.example

/**
 * Scope Functions
 * 객체를 사용할 때 Scope(범위, 영역) 를 일시적으로 만들어서 속성(property)나 함수를 처리하는 용도로 사용되는 함수이다.
 * 간편한 코드 사용과 가독성, 빌더 패턴의 이용, 부가적인 후처리 등을 하는 데에 도움을 준다.
 */

class ScopeFunctions {

    val person: Person = Person("Sg", 22)


    /**
     *  let 함수는 매개변수화된 타입 T의 확장 함수이다.(extension) 자기 자신을 받아서 R을 반환하는((T) -> R) 람다 식을 입력으로 받고,
     *  블럭 함수의 반환값 R을 반환
     */
    fun letSF() { // fun <T, R> T.let(block: (T) -> R): R

        val result = person?.let { Person(it.name, it.age) }

        println("${result.name} , ${result.age}")

    }

    /** with는 일반 함수이기 때문에 객체 receive를 직접 입력받고,
     * 객체를 사용하기 위한 두 번째 파라미터 블럭을 받는다.
     * T.()를 람다 리시버라고 하는데, 입력을 받으면 함수 내에서 this를 사용하지 않고도 입력받은 객체(receiver)의 속성을 변경할 수 있다.
     */
    fun withSF() { // fun <T, R> with(receiver: T, block: T.() -> R): R
        with(person) {
            println("${person.name} , ${person.age}")
        }
    }

    /** run은 with처럼 인자로 람다 리시버를 받고, 반환 형태도 비슷하게 생겼지만 T의 확장함수라는 점에서 차이가 있다.
     * 확장함수이기 때문에 safe call(.?)을 붙여 non-null 일 때에만 실행
     */
    fun runSF() { // fun <T, R> T.run(block: T.() -> R): R
        val nextAge: Int = person.run {
            age++
        }

        println("${person.name} , ${person.age}") // 57

    }

    fun run2SF() { // fun <T, R> T.run(block: T.() -> R): R
        val nextYear = person.run {
            val age = person.age++

            Person(name, age)
        }

        println("${person.name} , ${person.age}") // 57       

    }

    /**
     *  apply는 T의 확장 함수이고,
     *  블럭 함수의 입력을 람다 리시버로 받았기 때문에 블럭 안에서 객체의 프로퍼티를 호출할 때 it이나 this를 사용할 필요가 없다.
     *  run과 유사하지만 블럭에서 return 값을 받지 않으며 자기 자신인 T를 반환한다는 점이 다르다.
     */

    fun applySF() {
        val result = person.apply {
            name
            age = 30
        }
    }

    /**
     * also는 T의 확장함수이고, 블럭 함수의 입력으로 람다 리시버를 받지 않고 this로 받았다. apply와 마찬가지로 T를 반환한다.
     * 블럭 함수의 입력으로 T를 받았기 때문에 it을 사용해 프로퍼티에 접근하는 것을 볼 수 있다. 그래서 객체의 속성을 전혀 사용하지 않거나 변경하지 않고 사용하는 경우에 also를 사용
     */

    fun alsoSF() {
        val result = person.also {
            it.age = 20
        }
    }

    fun also2SF() {
        val numbers: ArrayList<String> = arrayListOf("one", "two", "three")

        numbers.also {
            println("before Add Four : $numbers")

        }.add("four").let { println("after Add Four : $numbers") }
    }


    data class Person(val name: String, var age: Int)

}