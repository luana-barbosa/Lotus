package com.example.details.domain.mapper

import com.example.details.data.response.TicketDetailsResponse
import com.example.details.domain.model.TicketDetails
import org.mapstruct.Mapper

@Mapper
interface DetailsMapper {
        fun responseToModel(ticketDetailsResponse: TicketDetailsResponse ): TicketDetails
}