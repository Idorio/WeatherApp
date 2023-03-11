package com.example.weatherapp.repository

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class WeatherInteractor @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun getWeather(): Response<WeatherResponse>{
        return weatherRepository.getWeather()
    }

}