package com.example.weatherapp.data.repositotyImpl

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.utils.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val apiService: ApiService):WeatherRepository {
    override suspend fun getWeather(): Response<WeatherResponse> {
       return withContext(Dispatchers.IO){
           apiService.getWeather()
        }
    }

}