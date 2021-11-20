package com.example.androidlab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlab3_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.toSecondButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about_text) {
                startActivity(Intent(this, ActivityAbout::class.java))
                return@setOnItemSelectedListener true
            }
            false
        }

        setContentView(binding.root)
    }
}