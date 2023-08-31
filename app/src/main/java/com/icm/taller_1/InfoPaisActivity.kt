package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyCallback.SignalStrengthsListener
import android.util.Log
import android.widget.TextView
import com.icm.taller_1.PaisesActivity.Country

class InfoPaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pais)


        val selectedCountryName = intent.getStringExtra("country")
        val selectedCountryCapital = intent.getStringExtra("capital") ?: "capital Desconocida"
        val selectedCountrySigla = intent.getStringExtra("sigla") ?: ""
        val selectedCountryIngles = intent.getStringExtra("nombreIngles") ?: ""
        if (selectedCountryName != null) {
            Log.d("pais",selectedCountryName)
            Log.d("capital",selectedCountryCapital)
            Log.d("sigla",selectedCountrySigla)
            Log.d("nombreIngles",selectedCountryIngles)


        }

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        textViewNombre.text = selectedCountryName ;

        val textViewCapital = findViewById<TextView>(R.id.textViewCapital)
        textViewCapital.text = selectedCountryCapital;

        val textViewSigla = findViewById<TextView>(R.id.textViewSigla)
        textViewSigla.text = selectedCountrySigla;

        val textViewNombreIngles = findViewById<TextView>(R.id.textViewNombreIngles)
        textViewNombreIngles.text = selectedCountryIngles;


    }
}