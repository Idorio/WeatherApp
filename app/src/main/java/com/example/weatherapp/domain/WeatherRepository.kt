package com.example.weatherapp.domain



import android.util.Log
import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface WeatherRepository  {

        suspend fun getWeather(): List<WeatherModel>

}