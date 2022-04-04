package com.example.details.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.details.domain.model.TicketDetails
import com.example.details.domain.usecase.GetTicketInfoUseCase
import com.example.network.response.Output
import kotlinx.coroutines.launch

class DetailsTicketViewModel(
    private val getTicketInfoUseCase: GetTicketInfoUseCase
    ) : ViewModel() {
    private val ticketInfo = MutableLiveData<Output<TicketDetails>>()

    val ticketDetailsInfo: LiveData<Output<TicketDetails>>
        get() = ticketInfo

    fun loadTicketInfo(ticketId: String) {
        viewModelScope.launch {
            val info = getTicketInfoUseCase(ticketId)

            ticketInfo.value = info
        }
    }
}