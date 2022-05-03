package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // Bad practice
    launch(SupervisorJob()) {
        coroutineContext.job.children
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Inner Coroutine")
        }
    }

    delay(3000)
}
