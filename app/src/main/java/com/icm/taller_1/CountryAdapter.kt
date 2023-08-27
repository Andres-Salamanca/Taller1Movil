package com.icm.taller_1
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class CountryAdapter(private val context: Context, private val countries: List<PaisesActivity.Country>) : BaseAdapter() {
    override fun getCount(): Int = countries.size

    override fun getItem(position: Int): Any = countries[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val country = getItem(position) as PaisesActivity.Country
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.activity_list_item, parent, false)


        // Find views using findViewById
        val textView2 = view.findViewById<TextView>(R.id.textView3)
        val textView3 = view.findViewById<TextView>(R.id.textView5)
        val textView4 = view.findViewById<TextView>(R.id.textView7)
        val textView5 = view.findViewById<TextView>(R.id.textView9)

        // Populate the views with data
        textView2.text = country.nombre_pais
        textView3.text =  country.nombre_pais_int
        textView4.text = country.capital
        textView5.text = country.sigla

        return view
    }
}
