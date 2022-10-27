package com.example.msuan

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import com.example.msuan.R
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val homeToNews: ImageView = findViewById(R.id.newsButton)
        homeToNews.setOnClickListener {
            startActivity(Intent(this, News::class.java))
        }

        val homeToChat: ImageView = findViewById(R.id.chatButton)
        homeToChat.setOnClickListener {
            startActivity(Intent(this, Chat::class.java))
        }
//setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?:"",provider ?:"")

        //LogOut Button
        val homeToLogout: ImageView = findViewById(R.id.signOut)
        homeToLogout.setOnClickListener {
            showLogout(email.toString(),ProviderType.BASIC)
        }

    }
    private fun setup(email: String,provider: String){

        title="Inicio"
        val emailHome: TextView =findViewById(R.id.emailTextViewHome)
        val providerHome: TextView =findViewById(R.id.providerTextViewHome)

        emailHome.text = email
        providerHome.text = provider
    }
    private fun showLogout(email: String, provider: ProviderType){
        val LogOutIntent = Intent(this, Logout::class.java).apply{
            putExtra("email",email)
            putExtra("provider",provider.name)

        }
        startActivity(LogOutIntent)
    }
}