package com.example.weatherapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "WeatherEntity")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("text")
    val text: Double,
    @ColumnInfo("temp_c")
    val temp_c: String?,
    @ColumnInfo("maxtemp_c")
    val maxtemp_c: String?,
    @ColumnInfo("mintemp_c")
    val mintemp_c: Double,
    @ColumnInfo("last_updated")
    val last_updated: String,
    @ColumnInfo("icon")
    val icon: String,
    @ColumnInfo("date")
    val date: String
): Serializable
