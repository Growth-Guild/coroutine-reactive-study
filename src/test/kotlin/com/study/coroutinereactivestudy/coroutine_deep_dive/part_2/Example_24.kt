package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(200)
            println("Job is done")
        } finally {
            println("Finally")
            launch {
                println("Will not be printed")
            }
            delay(100)
            println("Will not be printed")
        }
    }
    delay(100)
    job.cancelAndJoin()
    println("Cancel done")
}
