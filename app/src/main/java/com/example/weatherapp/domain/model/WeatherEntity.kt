package com.example.weatherapp.domain.model

import kotlin.math.roundToInt

data class WeatherEntity(
    val city: String,
    val lastUpdated: String,
    val temp_c: Double,
    val icon: String,
    val text: String,
    val forecast: List<ForecastDayEntity>
){
    fun getTemperatureRange(date: String): String {
        return forecast
            .first { it.date == date }
            .getTemperatureRange()
    }

    fun getCurrentDate(): String {
        return lastUpdated.split(" ").first()
    }

    fun getTemperatureInCelsius(): String {
        return "${temp_c.roundToInt()} °C"
    }
}