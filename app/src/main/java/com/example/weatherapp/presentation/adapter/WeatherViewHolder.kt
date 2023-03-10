package com.example.weatherapp.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemListBinding
import com.example.weatherapp.model.WeatherModel

class WeatherViewHolder( private val view: View): RecyclerView.ViewHolder(view) {

    private  val binding = ItemListBinding.bind(view)

    fun bind(weatherModel: WeatherModel) = with(binding){
        tvDate.text = weatherModel.time
        tvCondition.text= weatherModel.condition
        tvTemp.text= weatherModel.currentTemp
    }

}