package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(2000)
            println("Will not be printed")
        }
        try {
            withTimeout(1000) {
                delay(1500)
            }
        } catch (e: TimeoutCancellationException) {
            println("Thrown TimeoutCancellationException")
        }
    }
    launch {
        delay(2000)
        println("Done")
    }
}
