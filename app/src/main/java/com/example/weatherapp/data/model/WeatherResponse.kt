package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
@SerializedName("temperature")
val tempList: List<Temperature>
)
data class Temperature(
    val temp: String
)