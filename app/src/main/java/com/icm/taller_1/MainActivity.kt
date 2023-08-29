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
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (spinner.selectedItem.toString()) { //Obtener el elemento que se esta seleccionando dentro del spinner y se convierte en string para asignar un valor
                    "Español" -> saludo.text = "Bienvenido a TicTacToe" //Se le asigna un valor a la opción escogida
                    "English - Ingles" -> saludo.text = "Welcome to TicTacToe" //Se le asigna un valor a la opción escogida
                    "Français - Frances" -> saludo.text = "Bienvenue à TicTacToe" //Se le asigna un valor a la opción escogida
                    "Deutsch - Aleman" -> saludo.text = "Willkommen bei TicTacToe" //Se le asigna un valor a la opción escogida
                    "日本語 - Japones" -> saludo.text = "TicTacToe へようこそ" //Se le asigna un valor a la opción escogida
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                saludo.text = "" // Limpiar el mensaje de saludo si no se selecciona ningún idioma
            }
        }
        saludo.setOnClickListener{
            val intent = Intent(this, Saludo::class.java)
            intent.putExtra("Saludo", saludo.text.toString())
            startActivity(intent)
        }

        var spinner: Spinner = findViewById(R.id.spinner) //Spinner de paises
        var adaptador = ArrayAdapter<String>(this, R.array.idiomas, android.R.layout.simple_list_item_1)
        spinner.adapter = adaptador


              pais.setOnClickListener() {
            val pasarpais = Intent(this,PaisesActivity::class.java)
            startActivity(pasarpais)
        }
        juego.setOnClickListener {
            val intent = Intent(this, TicTacToe::class.java)
            startActivity(intent)
        }



    }
}