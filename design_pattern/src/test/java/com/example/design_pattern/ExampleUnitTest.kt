package com.example.design_pattern

import com.example.design_pattern.pattern_structure.bridge.BridgeClient
import com.example.design_pattern.pattern_structure.decorator.DecoratorClient
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        print("-------------------------------------------------------\n")
        print("-------------------------------------------------------\n")
        print("-------------------------------------------------------\n\n")

        //创建型：create


        //结构型：structure
//        BridgeClient.main(null)//桥接模式
        DecoratorClient.main(null)//10装饰器模式

        //行为型：action


        print("\n\n-------------------------------------------------------\n")
        print("-------------------------------------------------------\n")
        print("-------------------------------------------------------\n")
    }
}