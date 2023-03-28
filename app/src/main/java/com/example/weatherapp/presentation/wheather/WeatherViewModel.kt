package com.example.weatherapp.presentation.wheather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.service.model.WeatherModel
import com.example.weatherapp.domain.WeatherInteractor
import com.example.weatherapp.domain.model.WeatherEntity
import com.example.weatherapp.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) :
    ViewModel() {

    private val _currentTemp = MutableLiveData<Resources<WeatherEntity>>()
    val currentTemp: MutableLiveData<Resources<WeatherEntity>> get() = _currentTemp

    private val _location = MutableLiveData<Resources<WeatherEntity>>()
    val location: MutableLiveData<Resources<WeatherEntity>> get() = _location

    private val _error = MutableLiveData<String>()

    fun getWeather(city: String) {
        viewModelScope.launch {

            val response = weatherInteractor.getWeather(city)
            _currentTemp.postValue(response)
        }
    }

//    fun showData(city: String) {
//        viewModelScope.launch {
//            try {
//                weatherInteractor.showData(city)
//            } catch (e: Exception) {
//                Log.w("Insert data", e.message.toString())
//            }
//        }
//    }
}
























