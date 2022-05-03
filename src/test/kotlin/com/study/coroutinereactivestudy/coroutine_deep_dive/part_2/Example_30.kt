package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

fun main(): Unit = runBlocking {
    val hello = createHelloFoo("I'm not hello")
    println(hello)
}

suspend fun createHelloFoo(name: String): Foo = suspendCancellableCoroutine { continuation ->
    continuation.invokeOnCancellation {
        println("Cancellation invoked!!")
    }

    if (name != "hello") {
        continuation.cancel(Exception("name is not hello"))
    } else {
        continuation.resume(Foo("hello"))
    }
}

data class Foo(
    val name: String,
)
