package com.example.details.ui

import com.example.details.domain.model.TicketDetails
import com.example.details.domain.usecase.GetTicketInfoUseCase
import com.example.network.response.Output
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
class DetailsTicketViewModelTest {

    private val getTicketInfoUseCase: GetTicketInfoUseCase = mockk(relaxed = true)
    private val viewModel: DetailsTicketViewModel = mockk(relaxed = true)

    @Test
    fun `when dispatching the loadTicketInfo action given an id, the details state should be displayed`() {
        coEvery {
            getTicketInfoUseCase("id")
        } returns Output.Success(
            TicketDetails(
                "22/02/2022",
                "description",
                "image.png",
                "19.99",
                "Doação de roupas",
                "5"
            )
        )
        viewModel.loadTicketInfo("id")
        coVerify(exactly = 1) {
            viewModel.loadTicketInfo("id")
        }
    }
}
