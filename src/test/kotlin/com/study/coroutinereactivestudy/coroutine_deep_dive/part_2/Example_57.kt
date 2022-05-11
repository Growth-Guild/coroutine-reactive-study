package com.study.coroutinereactivestudy.coroutine_deep_dive.part_2

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class Example_57 {
    private val userRepository: UserRepository = mockk()
    private val accountRepository: AccountRepository = FaceAccountRepository()

    @ExperimentalCoroutinesApi
    @Test
    fun `유저 한 명을 조회한다`() = runTest {
        // given
        val userId = 1L
        coEvery {
            userRepository.getUserById(userId)
        } returns User(userId, "Hello")

        // when
        val user = userRepository.getUserById(userId)

        // then
        user.shouldNotBeNull()
        user.id shouldBe 1L
        user.name shouldBe "Hello"
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `실제로는 delay 시간이 3000ms 걸리지만 테스트에서는 시간을 스킵하여 진행할 수 있다`() = runTest {
        val deferredValue = async {
            println(currentTime)
            delay(3000)
            println(currentTime)
            30
        }
        deferredValue.await() shouldBe 30
    }
}

data class User(
    val id: Long,
    val name: String,
)

data class Account(
    val id: Long,
    val userId: Long,
    val balance: Long,
)

interface UserRepository {
    suspend fun getUserById(id: Long): User?
}

interface AccountRepository {
    suspend fun getAccountByUserId(userId: Long): List<Account>
}

class FaceAccountRepository : AccountRepository {
    override suspend fun getAccountByUserId(userId: Long): List<Account> {
        delay(2000)
        return listOf(
            Account(
                id = 1L,
                userId = userId,
                balance = 1000L,
            )
        )
    }
}
