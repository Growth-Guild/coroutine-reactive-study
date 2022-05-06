package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val a = coroutineScope {
        delay(2000)
        10
    }
    println("a is calculated")

    val b = coroutineScope {
        delay(2000)
        20
    }
    println(a)
    println(b)
}
