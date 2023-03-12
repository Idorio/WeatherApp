package com.example.weatherapp.domain

import com.example.weatherapp.model.WeatherModel
import javax.inject.Inject

class WeatherInteractor@Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun getWeather(): List<WeatherModel>{
        return weatherRepository.getWeather()
    }


}