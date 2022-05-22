package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

suspend fun main() {
    flowOf(1, 2, 3, 4)
        .onEach { println(it) }
        .collect()

    println()

    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart {
            println("On Start!")
            emit(0)
        }
        .collect { println(it) }

    println()
}
