package com.example.weatherapp.data









import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

 class WeatherRepositoryImpl@Inject constructor(private val apiService: ApiService):WeatherRepository {


     override suspend fun getWeather(city: String): Response<WeatherModel> {
         return withContext(Dispatchers.IO) {
             apiService.getWeather(city, "7ffea88483fb4e648a360906232403", 4)
         }
     }

 }

