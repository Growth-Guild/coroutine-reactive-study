package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import java.util.concurrent.Executors
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val dispatcher = Executors
        .newFixedThreadPool(5)
        .asCoroutineDispatcher()
    repeat(1000) {
        launch(dispatcher) {
            Thread.sleep(200)
            println("Running on thread: ${Thread.currentThread().name}")
        }
    }
    dispatcher.close()
}
