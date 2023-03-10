package com.example.weatherapp.data.service

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY= "316c0afdea184a17af3192716230903"
interface ApiService {

//    https://api.weatherapi.com/v1/forecast.json?key=316c0afdea184a17af3192716230903&q=London&days=7&aqi=no&alerts=no
    @GET("/forecast.json")
    suspend fun getWeather(@Query("q")city :String): Response<WeatherResponse>
}