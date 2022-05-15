package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>(
        capacity = 2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    launch {
        repeat(5) { idx ->
            channel.send(idx)
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
