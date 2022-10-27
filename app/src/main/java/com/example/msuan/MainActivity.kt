package com.example.msuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.msuan.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

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

        //Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message","Integracion de Firebase Completa")
        analytics.logEvent("InitScreen",bundle)

        val logToReg: Button=findViewById(R.id.signUp)
        logToReg.setOnClickListener {
            startActivity(Intent(this, Register::class.java ))
        }
        /*val logToHome: Button = findViewById(R.id.signIn)
        logToHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }*/
        setupl()
    }
    private fun setupl(){
        title="AutenticacionLogin"

        //Login Button
        val logeando: Button = findViewById(R.id.signIn)
        logeando.setOnClickListener {
            val campoEmailLog: TextView =findViewById(R.id.editTextEmailLogin)
            val campoPasswordLog: TextView =findViewById(R.id.editTextPasswordLogin)

            if (campoEmailLog.text.isNotEmpty() && campoPasswordLog.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(campoEmailLog.text.toString(),campoPasswordLog.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        showHome(it.result?.user?.email?:"",ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, Home::class.java).apply{
            putExtra("email",email)
            putExtra("provider",provider.name)

        }
        startActivity(homeIntent)
    }

}