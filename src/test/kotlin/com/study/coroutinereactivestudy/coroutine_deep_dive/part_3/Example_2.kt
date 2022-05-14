package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>()
    launch {
        repeat(5) { idx ->
            println("Send idx")
            delay(1000)
            channel.send(idx)
        }
        channel.close()
    }

    launch {
        for (element in channel) {
            println(element)
        }
        /*
        or
        channel.consumeEach { element ->
            println(element)
        }
        */
    }
}
