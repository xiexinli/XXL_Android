package com.example.base_library

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("---------------------------------------")
        println("---------------------------------------")

//        val tes= printTime
//        printTime()
//        tes()

        test1
        test2()

        logeXXL1(this, "xiexinli1")
//        logeXXL2(this, "xiexinli2")

        println("---------------------------------------")
        println("---------------------------------------")
    }

    private val test1 = {
        println("11111111111111")
    }
    val test2 = {
        println("22222222222")
    }
}