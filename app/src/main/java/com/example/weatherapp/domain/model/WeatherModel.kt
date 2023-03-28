package com.example.weatherapp.domain.model

import androidx.annotation.Keep
import androidx.room.Embedded

@Keep
data class WeatherModel(
    @Embedded
    val current: Current,
    val forecast: Forecast,
    val location: Location
)