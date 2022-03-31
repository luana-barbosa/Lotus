package com.example.details.data.repository

import com.example.details.data.service.DetailsApi
import com.example.details.domain.mapper.DetailsMapper
import com.example.details.domain.model.TicketDetails
import com.example.network.response.Output
import com.example.network.response.parseResponse

class AppDetailsRepository(private val detailsApi: DetailsApi, private val mapper: DetailsMapper) :
    DetailsRepository {
    override suspend fun getTicketInfo(ticketId: String): Output<TicketDetails> =
        when (val response = detailsApi.getTicketInfo(ticketId = ticketId).parseResponse()) {
            is Output.Success -> {
                Output.Success(mapper.responseToModel(response.body))
            }
            is Output.Failure -> {
                throw Exception()
            }
        }
}