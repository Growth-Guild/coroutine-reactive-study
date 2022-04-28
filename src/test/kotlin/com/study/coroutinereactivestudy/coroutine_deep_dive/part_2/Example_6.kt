package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx: CoroutineContext = CoroutineName("Hello World!")

    ctx[CoroutineName]?.let {
        println(it.name)
    } ?: println("CoroutineName is not exists..")

    ctx[Job]?.let {
        println("Job is exists!")
    } ?: println("Job is not exists..")
}
