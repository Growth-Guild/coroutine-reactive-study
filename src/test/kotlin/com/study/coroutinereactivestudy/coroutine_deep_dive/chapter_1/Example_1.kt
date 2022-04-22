package com.study.coroutinereactivestudy.coroutine_deep_dive.chapter_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(2000L)
        println("Awake!")
    }
    println("코루틴의 일시중단 함수는 쓰레드를 블로킹하지 않는다.")
}
