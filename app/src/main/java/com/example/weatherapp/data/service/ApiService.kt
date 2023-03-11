package com.example.weatherapp.data.service

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//    https://api.weatherapi.com/v1/forecast.json?key=316c0afdea184a17af3192716230903&q=London&days=7&aqi=no&alerts=no
interface ApiService {

    @GET("/forecast.json")
    suspend fun getWeather(
       @Query("apiKey")
       apiKey: String = API_KEY
    ): Response<WeatherResponse>
}