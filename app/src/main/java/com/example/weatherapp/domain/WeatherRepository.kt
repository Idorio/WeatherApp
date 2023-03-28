package com.example.weatherapp.domain

import com.example.weatherapp.domain.model.WeatherEntity
import com.example.weatherapp.utils.Resources

interface WeatherRepository {
    suspend fun getWeather(city: String): Resources<WeatherEntity>

//    suspend fun showWeather(city: String): List<WeatherEntity>
}