package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class InfoPaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pais)


        val selectedCountryName = intent.getStringExtra("country")
        if (selectedCountryName != null) {
            Log.d("pais",selectedCountryName)
        }

        val textviewpais = findViewById<TextView>(R.id.textView)

        textviewpais.text = selectedCountryName ;

    }
}