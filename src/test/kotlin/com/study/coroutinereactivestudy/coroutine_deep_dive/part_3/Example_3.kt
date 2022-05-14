package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main(): Unit = coroutineScope {
    val channel = produce {
        repeat(5) { idx ->
            println("Send idx")
            delay(1000)
            send(idx)
        }
    }

    for (i in channel) {
        println(i)
    }
}
