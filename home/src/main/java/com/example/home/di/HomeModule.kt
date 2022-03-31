package com.example.home.di

import com.example.home.data.repository.AppHomeRepository
import com.example.home.data.repository.HomeRepository
import com.example.home.data.service.HomeApi
import com.example.home.domain.GetHomeTicket
import com.example.home.domain.GetHomeTicketUseCase
import com.example.home.ui.home.HomeTicketViewModel
import com.example.network.retrofit.NetworkInicialization
import org.koin.dsl.module

val homeModule = module {
    single { NetworkInicialization().createService(HomeApi::class.java) }
    single <HomeRepository> { AppHomeRepository(get()) }
    single<GetHomeTicketUseCase> { GetHomeTicket(get()) }
    single { HomeTicketViewModel(get()) }
}
