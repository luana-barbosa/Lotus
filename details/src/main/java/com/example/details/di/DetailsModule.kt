package com.example.details.di

import com.example.details.data.repository.AppDetailsRepository
import com.example.details.data.repository.DetailsRepository
import com.example.details.data.service.DetailsApi
import com.example.details.domain.mapper.DetailsMapper
import com.example.details.domain.mapper.DetailsMapperImpl
import com.example.details.domain.usecase.GetTicketInfo
import com.example.details.domain.usecase.GetTicketInfoUseCase
import com.example.details.ui.DetailsTicketViewModel
import com.example.network.retrofit.NetworkInicialization
import org.koin.dsl.module

val detailsModule = module {
    single { NetworkInicialization().createService(DetailsApi::class.java) }

    single<DetailsRepository> {
        AppDetailsRepository(detailsApi = get(), mapper = get())
    }
    single<GetTicketInfoUseCase> {
        GetTicketInfo(repository = get())
    }
    single { DetailsTicketViewModel(getTicketInfoUseCase = get()) }

    single<DetailsMapper> { DetailsMapperImpl() }
}
