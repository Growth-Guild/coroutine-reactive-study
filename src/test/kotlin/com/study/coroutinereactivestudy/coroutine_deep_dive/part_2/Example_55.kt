package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var i = 0

@ExperimentalCoroutinesApi
suspend fun main(): Unit = coroutineScope {
    val dispatcher = Dispatchers.IO
        .limitedParallelism(1)

    repeat(10_000) {
        launch(dispatcher) { i++ }
    }
    delay(1000)
    println(i)
}
