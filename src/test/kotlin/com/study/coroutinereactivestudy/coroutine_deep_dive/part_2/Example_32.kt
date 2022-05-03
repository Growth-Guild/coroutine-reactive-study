package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch {
        val supervisorJob = SupervisorJob()
        launch(supervisorJob) {
            delay(1000)
            throw Error("Some error")
        }

        launch(supervisorJob) {
            delay(2000)
            println("Inner Coroutine")
        }
        supervisorJob.join()
    }
    launch {
        delay(3000)
        println("Outer Coroutine")
    }
}
