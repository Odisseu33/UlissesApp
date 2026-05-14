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

class CadastrarActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastrar2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNome = findViewById<EditText>(R.id.editTextText)
        val editEmail = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val editSenha = findViewById<EditText>(R.id.editTextTextPassword2)
        val editTelefone = findViewById<EditText>(R.id.editTextPhone)
        val btnCadastro = findViewById<Button>(R.id.buttonCadastroFeito)

        btnCadastro.setOnClickListener {
            val nome = editNome.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val senha = editSenha.text.toString()
            val telefone = editTelefone.text.toString().trim()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()

            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Digite um e-mail válido.", Toast.LENGTH_SHORT).show()

            } else if (senha.length < 4) {
                Toast.makeText(this, "A senha deve ter pelo menos 4 caracteres.", Toast.LENGTH_SHORT).show()

            } else {
                // Salva o email e a senha no SharedPreferences para o login ler depois
                val prefs = getSharedPreferences("usuario", MODE_PRIVATE)
                prefs.edit()
                    .putString("email", email)
                    .putString("senha", senha)
                    .putString("nome", nome)
                    .putString("telefone", telefone)
                    .apply()

                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        }
    }
}
