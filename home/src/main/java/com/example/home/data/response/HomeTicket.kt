package com.example.home.data.response

import java.io.Serializable

data class HomeTicket(
    val date: String = "",
    val description: String = "",
    val image: String = "",
    val price: String = "",
    val title: String = "",
    val id: String = ""
) : Serializable