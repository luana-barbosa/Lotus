package com.example.lotus

import android.app.Application
import com.example.details.di.detailsModule
import com.example.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicketApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicketApp)
            modules(listOf(detailsModule, homeModule))
        }
    }
}