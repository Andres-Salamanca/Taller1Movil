package com.icm.taller_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        var adaptador = ArrayAdapter<String>(this, R.array.idiomas, android.R.layout.simple_list_item_1)
        spinner.adapter = adaptador

        when(spinner.selectedItem.toString()) { //Obtener el elemento que se esta seleccionando dentro del spinner y se convierte en string para asignar un valor
            "Español" -> saludo.text = "Bienvenido a TicTacToe" //Se le asigna un valor a la opción escogida
            "English - Ingles" -> saludo.text = "Welcome to TicTacToe" //Se le asigna un valor a la opción escogida
            "Français - Frances" -> saludo.text = "Bienvenue à TicTacToe" //Se le asigna un valor a la opción escogida
            "Deutsch - Aleman" -> saludo.text = "Willkommen bei TicTacToe" //Se le asigna un valor a la opción escogida
            "日本語 - Japones" -> saludo.text = "TicTacToe へようこそ" //Se le asigna un valor a la opción escogida
        }
        saludo.setOnClickListener {
            Toast.makeText(applicationContext, "Hola", Toast.LENGTH_LONG).show()
        }


    }

}