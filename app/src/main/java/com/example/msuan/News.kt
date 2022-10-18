package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.msuan.R


class News : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val trendToHome: ImageView = findViewById(R.id.backtoHome)
        trendToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
        /*val bienToNewsDetail: ImageView = findViewById(R.id.conceButton)
        bienToNewsDetail.setOnClickListener {
            startActivity(Intent(this, NewsDetail::class.java))
        }
        val juegNewsDetail: ImageView = findViewById(R.id.valoButton)
        juegNewsDetail.setOnClickListener {
            startActivity(Intent(this, NewsDetail::class.java))
        }
        val ingToNewsDetail: ImageView = findViewById(R.id.compButton)
        ingToNewsDetail.setOnClickListener {
            startActivity(Intent(this, NewsDetail::class.java))
        }*/
    }
}