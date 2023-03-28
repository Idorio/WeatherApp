package com.example.weatherapp.data.service.model

import androidx.annotation.Keep
import androidx.room.Embedded
import java.io.Serializable

@Keep
data class ForecastDay(
    val astro: Astro,
    val date: String,
    val dateEpoch: Int,
    val day: Day,
    @Embedded
    val hour: List<Hour>
)