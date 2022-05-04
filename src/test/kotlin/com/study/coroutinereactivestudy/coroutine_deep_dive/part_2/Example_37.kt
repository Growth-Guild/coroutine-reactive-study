package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import java.util.concurrent.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object CustomNonPropagatingException : CancellationException()

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(2000)
            println("출력되지 않는다.")
        }
        throw CustomNonPropagatingException
    }
    launch {
        delay(3000)
        println("출력된다.")
    }
}
