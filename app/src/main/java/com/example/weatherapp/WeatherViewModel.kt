package com.example.weatherapp



import androidx.lifecycle.*




import com.example.weatherapp.domain.WeatherInteracrot
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.utils.weatherResponse

import com.example.weatherapp.utils.Resources

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherInteracrot: WeatherInteracrot) :
    ViewModel() {


    private val _currentTemp = MutableLiveData<Resources<WeatherModel>?>()
    val currentTemp: MutableLiveData<Resources<WeatherModel>?> get() = _currentTemp

    private val _location = MutableLiveData<Resources<WeatherModel>>()
    val location: MutableLiveData<Resources<WeatherModel>> get() = _location

    private val _currentDate = MutableLiveData<Resources<WeatherModel>?>()
    val currentDate: MutableLiveData<Resources<WeatherModel>?> get() = _currentDate


    private val _error = MutableLiveData<String>()

    init {
        getWeather()

    }


    private fun getWeather() {
        viewModelScope.launch {

            val response = weatherInteracrot.getWeather()
            _currentTemp.postValue(weatherResponse(response))
        }
    }


}
























