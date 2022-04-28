package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx1: CoroutineContext = CoroutineName("Name1")
    println(ctx1[CoroutineName]?.name)  // Name1
    println(ctx1[Job]?.isActive)   // null

    println()

    val ctx2: CoroutineContext = Job()
    println(ctx2[CoroutineName]?.name)  // null
    println(ctx2[Job]?.isActive)    // true

    println()

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name)  // Name1
    println(ctx3[Job]?.isActive)    // true

    println()

    val ctx4: CoroutineContext = CoroutineName("Name2")
    val ctx5 = ctx3 + ctx4
    println(ctx5[CoroutineName]?.name)  // Name2
    println(ctx5[Job]?.isActive)    // true

    println()

    println(ctx3[CoroutineName]?.name)  // Name1
    println(ctx3[Job]?.isActive)    // true
}
