package com.example.weatherapp.data.service.model

import androidx.annotation.Keep
import androidx.room.Embedded

@Keep
data class Forecast(
    @Embedded
    val forecastday: List<ForecastDay>
)