package com.example.weatherapp.data.service

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/forecast.json")
    suspend fun getWeather(): Response<WeatherResponse>
}