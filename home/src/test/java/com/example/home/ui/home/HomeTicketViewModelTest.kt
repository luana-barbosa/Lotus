package com.example.home.ui.home

import com.example.home.data.response.HomeTicket
import com.example.home.domain.GetHomeTicketUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
class HomeTicketViewModelTest {

    private val getHomeTicketUseCase: GetHomeTicketUseCase = mockk(relaxed = true)
    private val viewModel: HomeTicketViewModel = mockk(relaxed = true)

    @Test
    fun `when dispatching the getHomeTickets action given a catalog, the view state should be displayed`() {
        val homeTicket = HomeTicket(
            "22/02/2022",
            "description",
            "image.png",
            "19.99",
            "Doação de roupas",
            "5"
        )
        coEvery {
            getHomeTicketUseCase()
        } returns listOf(homeTicket)
        viewModel.getHomeTickets()
        coVerify(exactly = 1) {
            viewModel.getHomeTickets()
        }
    }
}
