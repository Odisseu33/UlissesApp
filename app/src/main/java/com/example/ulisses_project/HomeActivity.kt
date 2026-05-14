package com.example.ulisses_project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVagasOcupadas = findViewById<Button>(R.id.VagasOcupadas)
        val btnVagasLivres = findViewById<Button>(R.id.VagasLivres)
        val btnEntradas = findViewById<Button>(R.id.Entradas)
        val btnSaidas = findViewById<Button>(R.id.Saidas)
        val btnHistorico = findViewById<Button>(R.id.historico)

        // Botões do painel — exibem Toast por enquanto (telas futuras)
        btnVagasOcupadas.setOnClickListener {
            Toast.makeText(this, "Vagas Ocupadas (em breve)", Toast.LENGTH_SHORT).show()
        }

        btnVagasLivres.setOnClickListener {
            Toast.makeText(this, "Vagas Livres (em breve)", Toast.LENGTH_SHORT).show()
        }

        btnEntradas.setOnClickListener {
            Toast.makeText(this, "Entradas (em breve)", Toast.LENGTH_SHORT).show()
        }

        btnSaidas.setOnClickListener {
            Toast.makeText(this, "Saídas (em breve)", Toast.LENGTH_SHORT).show()
        }

        btnHistorico.setOnClickListener {
            Toast.makeText(this, "Histórico (em breve)", Toast.LENGTH_SHORT).show()
        }
    }
}
