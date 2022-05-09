package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import java.util.concurrent.Executors
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var i = 0

suspend fun main(): Unit = coroutineScope {
    val dispatcher = Executors.newSingleThreadExecutor()
        .asCoroutineDispatcher()
    repeat(10_000) {
        launch(dispatcher) { i++ }
    }
    delay(1000)
    println(i)
    dispatcher.close()
}
