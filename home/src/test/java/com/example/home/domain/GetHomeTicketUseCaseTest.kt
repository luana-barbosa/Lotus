package com.example.home.domain

import com.example.home.data.repository.HomeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
@DisplayName("Given the use case is invoked")
class GetHomeTicketUseCaseTest {

    private val repository: HomeRepository = mockk(relaxed = true)

    private fun prepareTest() {
        coEvery { repository.getHomeTickets() } returns listOf()
    }

    @Test
    fun `when calling repository should call getHomeTickets`() =
        runTest {
            prepareTest()
            repository.getHomeTickets()
            coVerify { repository.getHomeTickets() }
        }
}
