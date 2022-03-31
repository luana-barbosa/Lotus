package com.example.details.helper

import java.text.SimpleDateFormat
import java.util.*

class TicketDate {

    fun callDate(): String {
        val date = Calendar.getInstance().time
        var dateTimeFormat = SimpleDateFormat("dd/MM/yyyy")
        return dateTimeFormat.format(date)
    }
}