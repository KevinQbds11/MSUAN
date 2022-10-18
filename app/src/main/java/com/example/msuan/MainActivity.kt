package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.msuan.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*println("Hola mundo")
        val edadFirulais: Int = 2
        val edadFirulais2: Int = 3
        println("La edad de firulais es: $edadFirulais:Int y el tiempo que le queda de vida es: $edadFirulais2")
        val myVariable: Int = edadFirulais
        val nombre: String = "Juan"
        var myArray: String = "Mi nombre es $nombre y tiene ${nombre.length} caracteres"
        println(myArray[0])*/

        val logToReg: Button=findViewById(R.id.signUp)
        logToReg.setOnClickListener {
            startActivity(Intent(this, Register::class.java ))
        }
        val logToHome: Button = findViewById(R.id.signIn)
        logToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}