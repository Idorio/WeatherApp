package com.example.weatherapp.domain.model

data class ForecastDayEntity(
    val date: String,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val icon: String,
    val text: String
): java.io.Serializable {
    fun getTemperatureRange(): String {
        return "${mintemp_c.toInt()} °C/${maxtemp_c.toInt()}°C"
    }
}