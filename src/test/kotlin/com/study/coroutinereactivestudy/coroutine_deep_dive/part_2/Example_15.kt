package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job: Job = launch {
        delay(3000)
    }

    val parentJob: Job = coroutineContext.job
    println(job == parentJob)   // false
    val parentChildren: Sequence<Job> = parentJob.children
    println(parentChildren.first() == job)  // true
}
