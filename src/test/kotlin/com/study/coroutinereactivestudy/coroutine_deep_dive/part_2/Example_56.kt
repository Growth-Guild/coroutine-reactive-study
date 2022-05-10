package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@DelicateCoroutinesApi
suspend fun main(): Unit = withContext(newSingleThreadContext("Name1")) {
    var continuation: Continuation<Unit>? = null

    launch(newSingleThreadContext("Name2")) {
        delay(1000)
        continuation?.resume(Unit)
    }

    launch(Dispatchers.Unconfined) {
        println(Thread.currentThread().name)

        suspendCoroutine<Unit> { continuation = it }

        println(Thread.currentThread().name)

        delay(1000)

        println(Thread.currentThread().name)
    }
}
