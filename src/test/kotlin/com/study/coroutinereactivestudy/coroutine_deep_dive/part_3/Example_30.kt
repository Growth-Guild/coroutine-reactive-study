package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take

suspend fun main() {
    flowOf(1, 2, 3, 4)
        .map { it * it }
        .filter { it % 2 == 0 }
        .collect { println(it) }

    println()

    ('A'..'Z').asFlow()
        .take(5)
        .collect { println(it) }

    println()

    ('A'..'Z').asFlow()
        .drop(20)
        .collect { println(it) }

    println()
}
