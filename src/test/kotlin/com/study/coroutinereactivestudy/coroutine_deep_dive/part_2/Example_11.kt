package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

private fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main() = runBlocking(CoroutineName("main")) {
    log("Started")
    val v1 = async(CoroutineName("C1")) {
        delay(1000)
        log("Running async")    // [C1] Running async
        42
    }
    launch(CoroutineName("C2")) {
        delay(3000)
        log("Running launch")   // [C2] Running launch
    }
    log("The answer is ${v1.await()}")
    // [main] The answer is 42
}
