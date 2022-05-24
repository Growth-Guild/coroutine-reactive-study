package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

suspend fun present(place: String, message: String) {
    val ctx = coroutineContext
    val name = ctx[CoroutineName]?.name
    println("[$name] $message on $place")
}

fun messagesFlow(): Flow<String> = flow {
    present("flow builder", "Message")
    emit("Message")
}

suspend fun main() {
    val messages = messagesFlow()
    withContext(CoroutineName("Name1")) {
        messages.flowOn(CoroutineName("Name3"))
            .onEach { present("onEach", it) }
            .flowOn(CoroutineName("Name2"))
            .collect { present("collect", it) }
    }
}
