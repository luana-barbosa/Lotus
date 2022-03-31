package com.example.home.ui.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.data.response.HomeTicket
import com.example.home.domain.GetHomeTicketUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeTicketViewModel(
    private val getHomeTicketUseCase: GetHomeTicketUseCase,
) : ViewModel() {

    private val homeTicket: MutableLiveData<List<HomeTicket>> = MutableLiveData()

    fun getHomeTickets() {
        viewModelScope.launch(Dispatchers.IO) {
            homeTicket.postValue(getHomeTicketUseCase())
        }
    }

    fun observerTickets(
        lifecycleOwner: LifecycleOwner,
        action: (List<HomeTicket>) -> Unit,
    ) = homeTicket.observe(lifecycleOwner) {
        action(it)
    }
}