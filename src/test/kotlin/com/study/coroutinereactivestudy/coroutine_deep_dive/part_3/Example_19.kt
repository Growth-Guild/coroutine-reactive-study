package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .collect { println(it) }

    println()

    emptyFlow<Int>()
        .collect { println(it) }
}
