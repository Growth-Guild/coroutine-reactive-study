package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello~")
}
