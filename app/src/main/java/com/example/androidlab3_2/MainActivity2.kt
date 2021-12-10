package com.example.androidlab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidlab3_2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener {
            finish()
        }

        binding.bnToThird.setOnClickListener {
            launcherForResult.launch(Intent(this, MainActivity3::class.java))
        }

        binding.navView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.about_text) {
                startActivity(Intent(this, ActivityAbout::class.java))
                return@setOnItemSelectedListener true
            }
            false
        }

        setContentView(binding.root)
    }

    private var launcherForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                finish()
            }
        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}