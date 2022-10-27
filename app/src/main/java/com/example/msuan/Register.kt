package com.example.msuan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.msuan.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val regToLog: ImageView = findViewById(R.id.back)
        regToLog.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        setup()
    }
    private fun setup(){
        title = "Autenticación"
        val campoEmail: TextView =findViewById(R.id.editTextEmailRegister)
        val campoPassword: TextView =findViewById(R.id.editTextPasswordRegister)
        val campoPasswordRepeat: TextView =findViewById(R.id.editTextPasswordRegister2)
        val campoName: TextView =findViewById(R.id.editTextPersonNameRegister)
        val campoCareer: TextView =findViewById(R.id.editTextCareerRegister)
        val campoSede: TextView =findViewById(R.id.editTextSedeRegister)
        val campoCode: TextView =findViewById(R.id.editTextCodeRegister)
//Register Button
        val registrando: Button = findViewById(R.id.vamos)
        registrando.setOnClickListener {
            if (campoEmail.text.isNotEmpty() && campoPassword.text.isNotEmpty()==campoPasswordRepeat.text.isNotEmpty() && campoName.text.isNotEmpty() && campoCareer.text.isNotEmpty() && campoSede.text.isNotEmpty() && campoCode.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(campoEmail.text.toString(),campoPassword.text.toString()).addOnCompleteListener{
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
        val builder =AlertDialog.Builder(this)
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