package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("출력되지 않는다.")
        }

        launch {
            delay(300)
            println("출력된다.")
        }
    }

    launch {
        delay(2000)
        println("출력되지 않는다.")
    }
}
