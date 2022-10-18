package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.msuan.R

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val chatToHome: ImageView = findViewById(R.id.backButton)
        chatToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}