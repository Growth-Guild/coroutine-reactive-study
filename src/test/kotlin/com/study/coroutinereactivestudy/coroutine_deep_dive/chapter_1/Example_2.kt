package com.study.coroutinereactivestudy.coroutine_deep_dive.chapter_1

import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")
    val result = suspendCoroutine { continuation: Continuation<Int> ->
        println("Before too")
        thread {
            Thread.sleep(1000)
            continuation.resumeWith(Result.success(1000))
        }
    }
    println(result)
    println("After")
}
