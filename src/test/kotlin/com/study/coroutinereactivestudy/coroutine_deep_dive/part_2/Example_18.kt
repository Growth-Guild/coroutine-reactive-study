package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    val job1 = launch(job) {
        delay(1000)
        println("Text 1")
    }
    val job2 = launch(job) {
        delay(3000)
        println("Text 2")
    }
    job.join()
}
