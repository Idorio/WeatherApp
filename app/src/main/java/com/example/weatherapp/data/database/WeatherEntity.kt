package com.example.weatherapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("WeatherEntity")
data class WeatherEntity(

    @PrimaryKey(autoGenerate = false)


    @ColumnInfo("temp_c")
    val temp_c: Double

): Serializable
