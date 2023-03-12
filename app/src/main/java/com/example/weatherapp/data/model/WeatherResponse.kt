package com.example.weatherapp.data.model


import com.google.gson.annotations.SerializedName


data class WeatherResponse(
@SerializedName("sample")
val sampleList: List<Sample>)

data class Sample (
    @SerializedName("temp")
    val currentTemp: String,
    @SerializedName("city")
    val city: String
)
