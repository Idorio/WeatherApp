package com.example.weatherapp.data.database.dao.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ForecastDayDBModel(
    val date: String,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val icon: String,
    val text: String,
    val link_id: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}