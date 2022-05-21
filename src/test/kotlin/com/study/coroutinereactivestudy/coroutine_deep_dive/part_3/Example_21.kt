package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private fun makeFlow(): Flow<Int> = flow {
    repeat(3) { num ->
        delay(1000)
        emit(num)
    }
}

suspend fun main() = coroutineScope {
    makeFlow()
        .collect { println(it) }
}
