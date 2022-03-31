package com.example.home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.home.data.response.HomeTicket
import com.example.home.databinding.EventHomeTicketFragmentBinding
import com.example.home.ui.home.adapter.EventListAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeTicketFragment : Fragment() {
    private lateinit var binding: EventHomeTicketFragmentBinding
    private val ticketViewModel: HomeTicketViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventHomeTicketFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ticketViewModel.getHomeTickets()
        ticketViewModel.observerTickets(this) {
            setupAdapter(it)
        }
    }

    private fun setupAdapter(list: List<HomeTicket>) {
        binding.rvList.adapter = EventListAdapter(list) {
            navigate(it)
        }
    }

    private fun navigate(homeTicket: HomeTicket) {
        findNavController().apply {
            this.graph.find { navDestination ->
                navDestination.hasDeepLink(DETAILS_FRAGMENT.toUri())
            }?.let {
                this.navigate(it.id, bundleOf("id" to  homeTicket.id))
            }
        }
    }

    companion object {
        const val DETAILS_FRAGMENT = "app://DETAILS_SCREEN"
    }
}
