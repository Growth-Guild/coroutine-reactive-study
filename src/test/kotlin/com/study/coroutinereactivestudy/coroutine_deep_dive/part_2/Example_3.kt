package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

fun main() = runBlocking {
    val resultDeferred: Deferred<Int> = GlobalScope.async {
        delay(1000L)
        200
    }

    println("Before")
    val result: Int = resultDeferred.await()
    println("After")
    println(result)
}
