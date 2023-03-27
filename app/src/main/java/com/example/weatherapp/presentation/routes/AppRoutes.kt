package com.example.weatherapp.presentation.routes

import com.example.weatherapp.domain.model.ForecastDay

sealed class AppRoutes {
    object Search: AppRoutes()
    class Weather(val city: String): AppRoutes()
    class Details(val model: ForecastDay): AppRoutes()
}