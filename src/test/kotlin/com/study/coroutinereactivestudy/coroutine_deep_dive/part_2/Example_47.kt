package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import io.kotest.assertions.throwables.shouldThrow
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class Example_47 {

    @ExperimentalCoroutinesApi
    @Test
    fun testTime1() = runTest {
        withTimeout(10000) {
            delay(9000) // virtual time
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testTime2() = runTest {
        shouldThrow<TimeoutCancellationException> {
            withTimeout(1000) {
                delay(1100) // virtual time
            }
        }
    }

    @Test
    fun testTime3() = runBlocking {
        withTimeout(1000) {
            delay(900)  // 실제 900ms를 기다린다..
        }
    }
}
