package com.example.home.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.example.home.data.response.HomeTicket
import com.example.home.databinding.EventListItemBinding
import com.example.home.ui.home.viewholder.HomeViewHolder
import com.squareup.picasso.Picasso

class EventListAdapter(
    private val ticketList: List<HomeTicket>,
    private val listener: (HomeTicket) -> Unit,
) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = EventListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        with(ticketList[position]) {
            if (image.isNotEmpty())
                Picasso.get().load(image).placeholder(R.mipmap.ic_backdrop_foreground).into(holder.image)
            holder.title.text = title
            holder.eventView.setOnClickListener {
                listener(this)
            }
        }
    }

    override fun getItemCount(): Int = ticketList.size
}
