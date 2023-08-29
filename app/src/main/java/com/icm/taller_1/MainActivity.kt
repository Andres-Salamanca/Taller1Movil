package com.icm.taller_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var juego: Button = findViewById<Button>(R.id.juego) //Boton del juego
        var saludo: Button = findViewById<Button>(R.id.saludo) // Boton de saludo al jugador
        var pais: Button = findViewById<Button>(R.id.pais) //Boton de pais

        var spinner: Spinner = findViewById(R.id.spinner) //Spinner de pises
        var adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.idiomas))
        saludo.setOnClickListener{
            val intent = Intent(this, Saludo::class.java)
            intent.putExtra("Saludo", saludo.text.toString())
            startActivity(intent)
        }
        spinner.adapter = adaptador

        juego.setOnClickListener {
            val intent = Intent(this, TicTacToe::class.java)
            startActivity(intent)
        }


    }
}