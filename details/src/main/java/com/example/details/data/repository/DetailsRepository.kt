package com.example.details.data.repository

import com.example.details.domain.model.TicketDetails
import com.example.network.response.Output

interface DetailsRepository {
    suspend fun getTicketInfo(ticketId : String): Output<TicketDetails>
}