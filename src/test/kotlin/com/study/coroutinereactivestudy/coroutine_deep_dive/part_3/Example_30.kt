package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

suspend fun main() {
    flowOf(1, 2, 3)
        .map { it * it }
        .collect { print(it)}
}
