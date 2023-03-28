package com.example.weatherapp.data.service.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
): Serializable