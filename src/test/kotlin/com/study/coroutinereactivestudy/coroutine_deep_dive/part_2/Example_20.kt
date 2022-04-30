package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = Job()

    launch(job) {
        repeat(5) { num ->
            delay(200)
            println("Repeat num : $num")
        }
    }

    launch {
        delay(500)
        job.completeExceptionally((Error("Something error")))
    }

    job.join()

    launch(job) {
        println("Will not be printed")
    }

    println("Done")
}
