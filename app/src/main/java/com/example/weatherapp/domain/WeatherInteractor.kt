package com.example.weatherapp.domain

import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.utils.Resources
import com.example.weatherapp.utils.weatherResponse
import retrofit2.Response
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
    ) {

    suspend fun getWeather(city: String): Resources<WeatherModel> {
        var result: Resources<WeatherModel> = Resources.Loading()
        runCatching { weatherResponse(weatherRepository.getWeather(city))}
            .onFailure {
                result = Resources.Error(it.message ?: "Unknown error")
            }
            .onSuccess {
                result = it
            }
        return result
    }
}