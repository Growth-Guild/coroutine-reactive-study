package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job

fun main() {
    val ctx = CoroutineName("Name1") + Job()
    println(ctx[CoroutineName]?.name)   // Name1
    println(ctx[Job]?.isActive) // true

    val ctx2 = ctx.minusKey(CoroutineName)
    println(ctx[CoroutineName]?.name)   // null
    println(ctx[Job]?.isActive) // true
}
