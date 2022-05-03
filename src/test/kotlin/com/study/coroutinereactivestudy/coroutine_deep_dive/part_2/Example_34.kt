package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = SupervisorJob()
    launch(job) {
        delay(1000)
        throw Error("Some error")
    }

    launch(job) {
        delay(2000)
        println("출력된다")
    }
    job.join()
}
