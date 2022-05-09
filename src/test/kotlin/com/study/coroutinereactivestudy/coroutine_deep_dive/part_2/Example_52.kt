package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun main(): Unit = coroutineScope {
    launch(Dispatchers.Default) {
        println("Running on thread: ${Thread.currentThread().name}")
        withContext(Dispatchers.IO) {
            Thread.sleep(200)
            println("Running on thread: ${Thread.currentThread().name}")
        }
    }
}
