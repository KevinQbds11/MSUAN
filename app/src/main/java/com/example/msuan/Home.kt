package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.msuan.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeToLog: ImageView = findViewById(R.id.signOut)
        homeToLog.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val homeToNews: ImageView = findViewById(R.id.newsButton)
        homeToNews.setOnClickListener {
            startActivity(Intent(this, News::class.java))
        }
        val homeToChat: ImageView = findViewById(R.id.chatButton)
        homeToChat.setOnClickListener {
            startActivity(Intent(this, Chat::class.java))
        }

    }
}