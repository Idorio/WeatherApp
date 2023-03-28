package com.example.weatherapp.data.database.dao.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("WeatherDBModel")
class WeatherDBModel(
    @PrimaryKey
    val city: String,
    val lastUpdated: String,
    val temp_c: Double,
    val icon: String,
    val text: String
)