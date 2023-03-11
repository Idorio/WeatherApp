package com.example.weatherapp.repository

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

interface WeatherRepository {

    suspend fun getWeather() : Response<WeatherResponse>
}