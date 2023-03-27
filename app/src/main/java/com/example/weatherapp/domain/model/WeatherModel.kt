package com.example.weatherapp.domain.model

import androidx.annotation.Keep

@Keep
data class WeatherModel(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)