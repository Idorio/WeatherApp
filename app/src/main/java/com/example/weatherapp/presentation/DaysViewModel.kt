package com.example.weatherapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.weatherapp.domain.WeatherInteracrot
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class DaysViewModel @Inject constructor(private val weatherInteracrot: WeatherInteracrot):ViewModel() {







//    private val _bundle = MutableLiveData<WeatherBundle?>()
//    val bundle: LiveData<WeatherBundle?> = _bundle


//    fun getForecast() {
//        viewModelScope.launch {
//            try {
//                weatherInteracrot.getForecast()
//                val getForecast = weatherInteracrot.getForecast()
//                _currentWeather.value = getForecast
//            } catch (e: Exception) {
//                Log.w("getCurrentData", e.message.toString())
//            }
//        }
    }

