package com.example.weatherapp.data.service.model

import androidx.annotation.Keep

@Keep
data class WeatherModel(
    var current: Current,
    var forecast: Forecast,
    var location: Location
)