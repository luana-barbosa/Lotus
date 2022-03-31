package com.example.lotus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lotus.databinding.EventStartActivityBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding: EventStartActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EventStartActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
