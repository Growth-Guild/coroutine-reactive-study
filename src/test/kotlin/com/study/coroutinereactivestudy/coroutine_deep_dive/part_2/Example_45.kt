package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Before")
    withContext(SupervisorJob()) {
        launch {
            delay(1000)
            throw Error()
        }

        launch {
            delay(2000)
            println("Done")
        }
    }
    println("After")
}
