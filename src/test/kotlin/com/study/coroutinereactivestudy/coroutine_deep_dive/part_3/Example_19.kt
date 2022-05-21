package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .collect { println(it) }

    println()

    emptyFlow<Int>()
        .collect { println(it) }

    println()

    listOf(1, 2, 3, 4, 5)
        .asFlow()
        .collect { println(it) }

    val function = suspend {
        delay(1000)
        "UserName"
    }

    function.asFlow()
        .collect { println(it) }

    ::getUserName
        .asFlow()
        .collect { println(it) }
}

private suspend fun getUserName(): String {
    delay(1000)
    return "UserName"
}
