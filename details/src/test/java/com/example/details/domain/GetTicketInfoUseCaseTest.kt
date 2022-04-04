package com.example.details.domain

import com.example.details.domain.model.TicketDetails
import com.example.details.domain.usecase.GetTicketInfo
import com.example.network.response.Output
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName

@OptIn(ExperimentalCoroutinesApi::class)
@DisplayName("Given the use case is invoked")
class GetTicketInfoUseCaseTest {

    private val useCase: GetTicketInfo = mockk(relaxed = true)

    @Test
    fun `when repository response is success should return Result success `() {
        coEvery { useCase("id") } returns Output.Success(
            TicketDetails(
                "",
                "",
                "",
                "",
                "",
                ""
            )
        )
        runTest {
            val result = useCase("id")
            assertTrue { result is Output.Success }
            coVerify(exactly = 1) {
                useCase("id")
            }
        }
    }

    @Test
    fun `when repository response is error should return Result error `() {
        coEvery { useCase("id")  } returns Output.Failure(Error("msg"))
        runTest {
            val result = useCase("id")
            assertTrue { result is Output.Failure }
            coVerify(exactly = 1) {
                useCase("id")
            }
        }
    }
}
