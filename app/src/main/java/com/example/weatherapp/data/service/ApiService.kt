package com.example.weatherapp.data.service








import com.example.weatherapp.model.WeatherModel

import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query


//    https://api.weatherapi.com/v1/forecast.json?key=316c0afdea184a17af3192716230903 &q=Minsk&days=1&aqi=no&alerts=no
interface ApiService {

    @GET("forecast.json")
    suspend fun getWeather(
        @Query("q")
        q: String,
        @Query("key")
        key: String,
//        @Query("days")
//        days : String
    ): Response<WeatherModel>

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q")
        q: String,
        @Query("key")
        key: String



    ): Response<WeatherModel>


}