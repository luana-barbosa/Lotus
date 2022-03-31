package com.example.home.data.repository

import com.example.home.data.response.HomeTicket
import com.example.home.data.service.HomeApi
import com.example.network.response.Output
import com.example.network.response.parseResponse

class AppHomeRepository(
    private val service: HomeApi
) : HomeRepository {

    override suspend fun getHomeTickets(): List<HomeTicket> {
        return when (val homeWidgets = service.getHomeTickets().parseResponse()) {
            is Output.Success -> {
                homeWidgets.body
            }
            is Output.Failure -> {
                throw Exception()
            }
        }
    }
}

interface HomeRepository {
    suspend fun getHomeTickets(): List<HomeTicket>
}
