package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

private class MyError : Throwable("My error")

private val flow = flow {
    emit(1)
    emit(2)
    throw MyError()
}

private val flow2 = flow {
    emit("My message")
    throw MyError()
}

suspend fun main(): Unit {
    flow.onCompletion { println("Completed!") }
        .onEach { println("Got $it") }
        .catch {
            println("Caught $it")
            emit(-1)
        }
        .collect { println("Collected $it") }

    println()

    try {
        flow2.collect { println("Collected $it") }
    } catch (e: MyError) {
        println("Caught")
    }
}
