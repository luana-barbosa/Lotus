package com.example.details.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.details.R
import com.example.details.databinding.EventDetailsTicketFragmentBinding
import com.example.details.domain.model.TicketDetails
import com.example.details.helper.TicketDate
import com.example.network.response.Output
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.event_details_ticket_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsTicketFragment : Fragment() {

    private lateinit var binding: EventDetailsTicketFragmentBinding
    private lateinit var model: TicketDetails
    private val ticketData = TicketDate()
    private val ticketViewModel: DetailsTicketViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventDetailsTicketFragmentBinding.inflate(
            LayoutInflater.from(context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("id")?.let {
            setupObserver()
            setupListeners()
            ticketViewModel.loadTicketInfo(it)
            binding.toolbar.apply {
                inflateMenu(R.menu.details_menu);
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.action_share -> shareEvent()
                    }
                    true
                }
            }

        }
    }

    private fun updateInfoTicket(ticket: TicketDetails) {
        with(binding) {
            model = ticket
            titleEvent.text = ticket.title
            dateEvent.text = ticketData.callDate()
            overviewEvent.text = ticket.description
            priceEvent.text = "R$${model.price}"
            val backgroundImagePath = ticket?.image
            Picasso.get().load(backgroundImagePath).placeholder(R.mipmap.ic_backdrop_foreground).into(backdrop_event)
        }
    }

    private fun setupObserver() {
        ticketViewModel.ticketDetailsInfo.observe(viewLifecycleOwner) {
            when (it) {
                is Output.Success -> {
                    updateInfoTicket(it.body)
                }
            }
        }
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun shareEvent() {
        startActivity(
            Intent().apply {
                action = Intent.ACTION_SEND;
                putExtra(Intent.EXTRA_TEXT, "Oi, tudo bem? O evento ${model.title} que irá acontecer dia ${ticketData.callDate()}. Vamos?");
                type = "text/plain";
            }
        )
    }
}
