package com.example.weatherapp.adaptet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemListBinding
import com.example.weatherapp.model.WeatherModel

class WeatherViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemListBinding.bind(view)

    fun bind(item: WeatherModel) = with(binding){
        tvDate.text = item.time
        tvCondition.text= item.condition
        tvTemp.text= item.currentTemp
    }

}