package com.example.msuan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.msuan.R

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val regToHome: Button = findViewById(R.id.vamos)
        regToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
        val regToLog: ImageView = findViewById(R.id.back)
        regToLog.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}