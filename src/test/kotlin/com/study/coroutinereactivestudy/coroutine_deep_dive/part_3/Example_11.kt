package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

fun CoroutineScope.numbers(): ReceiveChannel<Int> = produce {
    repeat(3) { num ->
        send(num + 1)
    }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
    for (number in numbers) {
        send(number * number)
    }
}

suspend fun main() = coroutineScope {
    val numbers = numbers()
    val squared = square(numbers)
    for (num in squared) {
        println(num)
    }
}
