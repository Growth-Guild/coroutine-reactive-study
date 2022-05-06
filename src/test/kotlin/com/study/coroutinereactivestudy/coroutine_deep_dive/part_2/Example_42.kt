package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import kotlinx.coroutines.*

class Example_42 {
    data class User(
        val name: String,
        val profileImagePath: String,
    )
}

suspend fun getUserProfile(): Example_42.User = coroutineScope {
    val userName = async {
        delay(2000)
        "Hello"
    }

    val profileImagePath = async {
        delay(3000)
        "/hello/profile-image"
    }

    Example_42.User(
        name = userName.await(),
        profileImagePath = profileImagePath.await()
    )
}

fun main() = runBlocking {
    val userProfile = async(CoroutineName("Parent")) {
        getUserProfile()
    }
    println(userProfile.await())
}
