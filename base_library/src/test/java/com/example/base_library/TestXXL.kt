package com.example.base_library

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestXXL {
    @Test
    fun test1() {
        val lastChar = "".lastChar()
    }

    @Test
    fun test2() {
        runBlocking {
            val hotFlow = MutableSharedFlow<Int>()

            launch {
                repeat(5) {
                    delay(1000)
                    hotFlow.emit(it)
                }
            }

            // 观察者1
            hotFlow.collect {
                println("Observer 1: $it")
            }

            // 观察者2
            delay(3000) // 观察者2延迟3秒后订阅
            hotFlow.collect {
                println("Observer 2: $it")
            }

            delay(5000) // 为了保持主线程运行
        }
    }
}