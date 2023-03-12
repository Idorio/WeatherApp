package com.example.weatherapp.data.model


import com.google.gson.annotations.SerializedName


data class WeatherResponse(
@SerializedName("sample")
val sampleList: List<Sample>)

data class Sample (
    @SerializedName("Temp")
    val currentTemp: String
)
