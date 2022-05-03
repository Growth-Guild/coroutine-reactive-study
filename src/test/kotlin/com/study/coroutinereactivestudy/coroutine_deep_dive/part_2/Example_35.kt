package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Inner 코루틴")
        }
    }
    delay(1000)
    println("Done")
}
