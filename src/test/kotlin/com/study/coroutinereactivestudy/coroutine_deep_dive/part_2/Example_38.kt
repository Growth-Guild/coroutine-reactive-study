package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { ctx, exception ->
        println("exception - $exception")
    }
    val scope = CoroutineScope(SupervisorJob() + handler)
    scope.launch {
        delay(1000)
        throw Error("Some error")
    }

    scope.launch {
        delay(2000)
        println("출력된다.")
    }
    scope.coroutineContext.job.children.forEach { it.join() }
}
