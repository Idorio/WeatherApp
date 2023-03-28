package com.example.weatherapp.domain

import com.example.weatherapp.data.database.WeatherEntity
import com.example.weatherapp.data.model.WeatherResp
import com.example.weatherapp.domain.model.Current
import com.example.weatherapp.domain.model.WeatherModel

import retrofit2.Response

interface WeatherRepository {




    suspend fun getWeather(city: String): Response<WeatherModel>

    suspend fun showWeather(city: String)


}