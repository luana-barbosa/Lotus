package com.example.details.data.service

import com.example.details.data.response.TicketDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("events/{ticketId}")
    suspend fun getTicketInfo(@Path("ticketId") ticketId: String): Response<TicketDetailsResponse>
}