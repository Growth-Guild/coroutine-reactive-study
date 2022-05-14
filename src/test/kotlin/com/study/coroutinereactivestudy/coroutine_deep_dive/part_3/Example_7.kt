package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = Channel.CONFLATED) {
        repeat(5) { idx ->
            send(idx)
            delay(100)
            println("Sent")
        }
    }

    delay(1000)
    for (i in channel) {
        println(i)
        delay(1000)
    }
}
