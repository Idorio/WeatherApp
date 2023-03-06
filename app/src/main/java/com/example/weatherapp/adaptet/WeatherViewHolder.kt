package com.example.weatherapp.adaptet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemListBinding
import com.example.weatherapp.model.WeatherModel

class WeatherViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private  val binding = ItemListBinding.bind(view)

    fun bind(itemWeather: WeatherModel) = with(binding){
        tvDate.text = itemWeather.time
        tvCondition.text= itemWeather.condition
        tvTemp.text= itemWeather.currentTemp
    }

}