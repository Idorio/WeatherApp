package com.example.weatherapp.domain.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class ForecastDay(
    val astro: Astro,
    val date: String,
    val dateEpoch: Int,
    val day: Day,
    val hour: List<Hour>
) : Serializable {
    fun getTemperatureRange(): String {
        return "${day.mintemp_c.toInt()} °C/${day.maxtemp_c.toInt()}°C"
    }
}