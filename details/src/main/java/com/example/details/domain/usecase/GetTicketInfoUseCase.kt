package com.example.details.domain.usecase

import com.example.details.data.repository.DetailsRepository
import com.example.details.domain.model.TicketDetails
import com.example.network.response.Output

interface GetTicketInfoUseCase {
    suspend operator fun invoke(ticketId : String): Output<TicketDetails>
}

class GetTicketInfo(private val repository: DetailsRepository) : GetTicketInfoUseCase {
    override suspend fun invoke(ticketId : String): Output<TicketDetails> =
        repository.getTicketInfo(ticketId)
}