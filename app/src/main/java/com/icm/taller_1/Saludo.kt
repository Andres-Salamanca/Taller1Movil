package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Saludo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        val saludoIdioma = findViewById<TextView>(R.id.greet)

        val intent = intent
        val saludo = intent.getStringExtra("Saludo")

        if (saludo != null) {
            saludoIdioma.text = saludo
        }
    }
}