package com.example.weatherapp.domain

import com.example.weatherapp.domain.model.WeatherModel

import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(city: String): Response<WeatherModel>

}