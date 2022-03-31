package com.example.home.domain

import com.example.home.data.repository.HomeRepository
import com.example.home.data.response.HomeTicket

interface GetHomeTicketUseCase {
    suspend operator fun invoke(): List<HomeTicket>
}

class GetHomeTicket(private val repository: HomeRepository) : GetHomeTicketUseCase {
    override suspend fun invoke(): List<HomeTicket> =
        repository.getHomeTickets()
}