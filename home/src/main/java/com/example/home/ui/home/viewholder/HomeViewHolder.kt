package com.example.home.ui.home.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.google.android.material.circularreveal.CircularRevealGridLayout

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val title: TextView = itemView.findViewById(R.id.title_event)
    val image: ImageView = itemView.findViewById(R.id.backdrop_event)
    val eventView: CircularRevealGridLayout = itemView.findViewById(R.id.eventView)
}