package com.example.weatherapp.domain

import com.example.weatherapp.domain.model.WeatherEntity
import com.example.weatherapp.utils.Resources
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend fun getWeather(city: String): Resources<WeatherEntity> {
        var result: Resources<WeatherEntity> = Resources.Loading()
        runCatching { weatherRepository.getWeather(city) }
            .onFailure {
                result = Resources.Error(it.message ?: "Unknown error")
            }
            .onSuccess {
                result = it
            }
        return result
    }

//    suspend fun showData(city: String): List<WeatherModel> {
//        return weatherRepository.showWeather(city)
//    }
}