package com.icm.taller_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import org.json.JSONArray
import java.io.InputStream
import java.io.FileInputStream
import java.io.IOException
import android.util.Log
import org.json.JSONException
import org.json.JSONObject

class PaisesActivity : AppCompatActivity() {

    data class Country(
        val capital: String,
        val nombre_pais: String,
        val nombre_pais_int: String,
        val sigla: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paises)


        val jsonArray = readJsonFromAssets(this, "paises.json")

        val countryList = mutableListOf<PaisesActivity.Country>()
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val country = PaisesActivity.Country(
                    jsonObject.getString("capital"),
                    jsonObject.getString("nombre_pais"),
                    jsonObject.getString("nombre_pais_int"),
                    jsonObject.getString("sigla")
                )
                countryList.add(country)
            }
        }

        val listView = findViewById<ListView>(R.id.Listview)
        val adapter = CountryAdapter(this, countryList)
        listView.adapter = adapter



        listView.setOnItemClickListener { _, _, position, _ ->

            val selectedCountry = countryList[position].nombre_pais

            val intent = Intent(this, InfoPaisActivity::class.java)
            intent.putExtra("country", selectedCountry)
            startActivity(intent)
        }
    }

    fun readJsonFromAssets(context: Context, fileName: String): JSONArray? {
        var inputStream: InputStream? = null
        return try {
            inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val json = String(buffer, Charsets.UTF_8)
            val jsonObject = JSONObject(json)  // Parse the outer JSON object
            val jsonArray = jsonObject.getJSONArray("paises")  // Extract the inner JSON array
            jsonArray  // Return the extracted array
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        } finally {
            inputStream?.close()
        }
    }
}