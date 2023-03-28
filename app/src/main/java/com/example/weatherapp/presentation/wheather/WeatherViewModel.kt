package com.example.weatherapp.presentation.wheather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherResp
import com.example.weatherapp.domain.CityInteractor
import com.example.weatherapp.domain.WeatherInteractor
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.utils.Resources
import com.example.weatherapp.utils.weatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
    ) :
    ViewModel() {

    private val _currentTemp = MutableLiveData<Resources<WeatherModel>>()
    val currentTemp: MutableLiveData<Resources<WeatherModel>> get() = _currentTemp

    private val _location = MutableLiveData<Resources<WeatherModel>>()
    val location: MutableLiveData<Resources<WeatherModel>> get() = _location

    private val _error = MutableLiveData<String>()

    fun getWeather(city: String) {
        viewModelScope.launch {

            val response = weatherInteractor.getWeather(city)
            _currentTemp.postValue(response)
        }
    }

    fun showData(city: String) {
        viewModelScope.launch {
            try {
                weatherInteractor.showData(city)
            } catch (e: Exception) {
                Log.w("Insert data", e.message.toString())
            }
        }
    }
}
























