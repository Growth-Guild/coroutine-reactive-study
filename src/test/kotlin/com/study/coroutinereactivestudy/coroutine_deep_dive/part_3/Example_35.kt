package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

fun flowFrom(element: String) = flowOf(1, 2, 3)
    .onEach { delay(1000) }
    .map { "${it}_${element}" }

suspend fun main() {
    flowOf("A", "B", "C")
        .flatMapConcat { flowFrom(it) }
        .collect { println(it) }
}
