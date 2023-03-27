package com.example.weatherapp.domain.model

import androidx.annotation.Keep

@Keep
data class Forecast(
    val forecastday: List<ForecastDay>
){
    fun getTemperatureRange(date: String): String {
        return forecastday
            .first { it.date == date }
            .getTemperatureRange()
    }
}