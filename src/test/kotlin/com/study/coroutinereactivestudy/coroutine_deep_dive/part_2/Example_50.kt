package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Example_50 {
    private val dispatcher = Executors
        .newSingleThreadExecutor()
        .asCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @BeforeEach
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @ExperimentalCoroutinesApi
    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain() // 메인 디스패처를 원래의 메인 디스패처로 리셋한다.
        dispatcher.close()
    }

    @Test
    fun testSomething(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            val name = Thread.currentThread().name
            println(name)
        }
    }
}
