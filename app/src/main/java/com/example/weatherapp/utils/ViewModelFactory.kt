package com.example.weatherapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.domain.WeatherInteractor

class ViewModelFactory (private val weatherInteractor: WeatherInteractor):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherInteractor) as T
    }
}