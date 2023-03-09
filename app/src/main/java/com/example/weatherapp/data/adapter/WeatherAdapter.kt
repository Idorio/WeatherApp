package com.example.weatherapp.data.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.WeatherModel

class WeatherAdapter() : RecyclerView.Adapter<WeatherViewHolder>() {

    private var listItem = mutableListOf<WeatherModel>()
    fun submitList(list: MutableList<WeatherModel>){
        this.listItem = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return WeatherViewHolder(view)
    }
        override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(listItem[position])
    }
    override fun getItemCount(): Int {
        return listItem.size
    }

}


