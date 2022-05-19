package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

private fun getList(): List<String> = List(3) {
    Thread.sleep(1000)
    "User $it"
}

private fun getSequence(): Sequence<String> = sequence {
    repeat(3) {
        Thread.sleep(1000)
        yield("User $it")
    }
}

private fun getFlow(): Flow<String> = flow {
    repeat(3) {
        delay(1000)
        emit("User $it")
    }
}

@DelicateCoroutinesApi
suspend fun main() {
    withContext(newSingleThreadContext("main")) {
        launch {
            repeat(3) {
                delay(100)
                println("Processing on coroutine")
            }
        }
        val list = getFlow()
        list.collect { println(it) }
    }
}
