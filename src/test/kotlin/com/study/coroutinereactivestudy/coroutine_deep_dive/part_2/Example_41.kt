package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

suspend fun longTask2() = coroutineScope {
    launch {
        delay(1000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 1")
    }

    launch {
        delay(2000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 2")
    }
}

fun main() = runBlocking {
    val job = launch(CoroutineName("Parent")) {
        longTask2()
    }
    delay(1500)
    job.cancel()
}
