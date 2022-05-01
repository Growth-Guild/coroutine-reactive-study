package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(100)
            Thread.sleep(100)
            println("Printing number $i")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancelled successfully")
}
