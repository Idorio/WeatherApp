package com.example.weatherapp.data.item_repository_impl

import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl@Inject constructor(private val apiService: ApiService): WeatherRepository{
    override suspend fun getWeather(): List<WeatherModel> {
        return withContext(Dispatchers.IO){
            val response = apiService.getWeather()
            response.body()?.sampleList?.let {
                it.map {
                    WeatherModel(it.currentTemp)
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }


}