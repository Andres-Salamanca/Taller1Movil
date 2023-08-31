package com.icm.taller_1
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CountryAdapter(private val context: Context, private val countries: List<PaisesActivity.Country>) : BaseAdapter() {
    override fun getCount(): Int = countries.size

    override fun getItem(position: Int): Any = countries[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val country = getItem(position) as PaisesActivity.Country
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.activity_list_item, parent, false)


        // Find views using findViewById
        val imageview = view.findViewById<ImageView>(R.id.imageView2)
        val textView2 = view.findViewById<TextView>(R.id.textView3)

        Picasso.get().load("https://flagsapi.com/${country.sigla}/flat/64.png").into(imageview)
        // Populate the views with data
        textView2.text = country.nombre_pais

        return view
    }
}
