package com.example.weatherapp.model

data class WeatherModel(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)