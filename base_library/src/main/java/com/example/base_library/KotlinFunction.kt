package com.example.base_library

import android.util.Log

/**
 * 帖子：一文吃透 Kotlin 中眼花缭乱的函数家族
 * 网址：https://mp.weixin.qq.com/s/KsVbVBLAAMe9dNW5Us09vw
 * 网址：https://mp.weixin.qq.com/s/KsVbVBLAAMe9dNW5Us09vw
 * 网址：https://mp.weixin.qq.com/s/KsVbVBLAAMe9dNW5Us09vw
 * */
class KotlinFunction {

    val stringLength: Int? = stringLengthFunc("Android")
    val tes = printTime

    fun testFun1() {
        printTime()
    }


}

/**
 * 2:lambda 表达式和匿名函数
 *
 * Kotlin 中并不要求函数都拥有名称，只声明其必要的输入类型、输出类型以及表达式即可完成函数的定义。
 *
 * 比如：String 即为输入参数类型，Int 为输出类型，花括号内为 lambda 表达式：
 * it 是隐式参数名称，也可任意拟定，比如这里用 input 指定。如果不需要参数的话也可以省略
 * 如果有不需要的参数一般用下划线_取代其名称
 * */

//input.length 为计算逻辑以及表达式返回值
val stringLengthFunc: (String) -> Int? = { input ->
    input.length
}

val printTime: () -> Unit = {
    println("Test current:${System.currentTimeMillis()}")
}

fun logeXXL1(any: Any, msg: String? = "") {
    Log.e(any.toString(), "logeXXL1:--------------$msg ")
}

val logeXXL2: (any: Any, msg: String?) -> Unit = { any, msg ->
    Log.e(any.toString(), "logeXXL2:--------------$msg ")
}

/**
 * 3:高阶函数
 *
 * 高阶函数是将函数用作参数或返回值的函数。
 * 支持高阶函数是 Kotlin 函数式编程的一大特性，这在 Kotlin 源码中有大量的使用。
 * */

//函数作为参数
//Kotlin 中函数执行的时候如果需要回调参数继续处理，则无需像 Java 那样定义接口，而是直接将函数作为参数传入。
//如下的 stringMapper 即为高阶函数，mapper 即为函数参数的引用名称。
//class Temp {
//    fun stringMapper(input: String, mapper: (String) -> Int): Int {
//        return mapper(input)
//    }
//}

//匿名函数参数
//首先这个函数参数的传入可以是匿名函数的引用，比如：
class Temp1 {
    val temp = "ddd"
    val stringLengthFunc: (String) -> Int = { input ->
        input.length
    }

    fun main() {
        stringMapper("Android", stringLengthFunc)



        stringMapper(
            "Android", { input ->
                input.length
            }, 0
        )

        stringMapper("Android") { input ->
            input.length
        }

        stringMapperNew { input ->
            input.length
        }
    }


    fun stringMapper(input: String, mapper: (String) -> Int, num: Int): Int {
        return mapper(input)
    }

    fun stringMapper(input: String, mapper: (String) -> Int): Int {
        return mapper(input)
    }

    fun stringMapperNew(mapper: (String) -> Int): Int {
        return mapper(temp)
    }
}

//具名函数参数
// 除了传入匿名函数的方法体或引用，
// 还可以传入普通函数的名称作为参数。写法稍稍不同，::functionName 的形式。
class Temp2 {
    private fun stringLengthInner(input: String) = input.length

    fun main() {
        stringMapper("Android", ::stringLengthInner)
    }

    fun stringMapper(input: String, mapper: (String) -> Int): Int {
        return mapper(input)
    }
}

//函数作为返回值
//如果函数并非想要知道处理结果，只想获得处理方法的话，
// 可以将返回值定义成匿名函数的规格，并在 return 里写上匿名函数的实现。
fun stringMapperFunction(input: String): (String) -> Int {
    return {
        val newString = input.substring(input.indexOf("start"))
        newString.length
    }
}

//与 let 等函数的关系
//let 等函数是结合了 inline 函数、扩展函数的高阶函数，以 let 为例看下源码：
//
//@kotlin.internal.InlineOnly
//public inline fun <T, R> T.let(block: (T) -> R): R {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    return block(this)
//}
//
// 可以看到：
//
//其实是 T 类型的扩展函数，接受引用名称为 block 、参数类型为 T、返回类型为 R 的匿名函数
//函数本身又返回和匿名函数参数相同的 R 类型
//方法体内构建完 contract 之后即调用 block 函数并返回


/**
 * 4: 扩展函数和扩展属性
 *
 * 扩展函数
 * Kotlin 可以实现扩展一个类的新功能而无需继承该类。
 * 比如可以为一个不能修改的第三方库中的类编写一个新的函数，
 * 这个新增的函数就像那个原始类本来就有的函数一样，可以用普通的方法调用。这种机制称为扩展函数。
 * */

//String. 表示扩展的目标类
//lastChar 即函数名
//Char 即函数返回类型
//this 代表当前类的实例，并非必须、可省略
//[...] 即函数体
fun String.lastChar(): Char = this[length - 1]

//泛型扩展函数
//对于泛型类的也可以拥有扩展函数，只不过需要在声明的函数前指定泛型，否则无法扩展成功。
//
//比如给 MutableMap 添加新的函数：
//fun <K, V>  MutableMap<K, V> .putLast(): V? {
//
//}

//与 apply 等函数的关系
//以 apply 函数，了解下源码中扩展函数的应用：
//public inline fun <T> T.apply(block: T.() -> Unit): T {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    block()
//    return this
//}


val <T> List<T>.last: T get() = get(size - 1)

class Test4 {
    val <T> List<T>.last: T get() = get(size - 1)

    val listString = listOf("Android Q", "Android N", "Android M")

    fun main() {
        println("listString.last${listString.last}")
    }
}

data class Person(var name: String, var age: Int)

operator fun Int.plus(p: Person) = this - p.age

fun testOperator() {
    val person1 = Person("A", 3)
    println("testInt+person1=${5 + person1}")
    println("testInt+person1=${5.plus(person1)}")
}