package com.example.ulisses_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editSenha = findViewById<EditText>(R.id.editTextTextPassword)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val btnCadastrar = findViewById<Button>(R.id.buttonCadastrar)

        btnLogin.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val senha = editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha o e-mail e a senha.", Toast.LENGTH_SHORT).show()

            } else {
                // Lê o email e a senha que foram salvos no cadastro
                val prefs = getSharedPreferences("usuario", MODE_PRIVATE)
                val emailSalvo = prefs.getString("email", "")
                val senhaSalva = prefs.getString("senha", "")

                if (email == emailSalvo && senha == senhaSalva) {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastrarActivity2::class.java)
            startActivity(intent)
        }
    }
}
