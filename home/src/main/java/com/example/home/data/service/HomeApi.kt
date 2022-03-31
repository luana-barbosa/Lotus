package com.example.home.data.service

import com.example.home.data.response.HomeTicket
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("events")
    suspend fun getHomeTickets(): Response<List<HomeTicket>>
}