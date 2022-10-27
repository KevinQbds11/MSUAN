package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class Logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val logoutToHome: ImageView =findViewById(R.id.backtoHome4)
        logoutToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java ))
        }
        /*val logoutFinal: Button =findViewById(R.id.logout)
        logoutFinal.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java ))
        }*/
        //setupOut
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
       // setupOut(email ?:"",provider ?:"")
        val saliendo: TextView =findViewById(R.id.logOut)
        saliendo.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            alert()
            showLogin()
        }
    /*private fun setupOut(email: String,provider:String){
        title="Logout"
        val emailHome: TextView =findViewById(R.id.emailTextViewHome)
        val providerHome: TextView =findViewById(R.id.providerTextViewHome)

        emailHome.text = email
        providerHome.text = provider
//LogOut Button*/

        }



    private fun showLogin(){
        val loginIntent = Intent(this, MainActivity::class.java)
        startActivity(loginIntent)
    }

    private fun alert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Log Out Alert")
        builder.setMessage("You have log Out Succesfully")
        builder.show()
    }
}