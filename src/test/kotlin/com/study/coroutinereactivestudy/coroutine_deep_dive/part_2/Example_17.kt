package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(1000)
        println("Test1")
    }

    val job2 = launch {
        delay(3000)
        println("Test2")
    }

    coroutineContext[Job]
        ?.children
        ?.forEach { it.join() }
    println("All tests are done")
}
