package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = launch { delay(1000) }
    job.invokeOnCompletion { exception: Throwable? ->
        println(exception)
        println("Finished")
    }
    delay(400)
    job.cancelAndJoin()
}
