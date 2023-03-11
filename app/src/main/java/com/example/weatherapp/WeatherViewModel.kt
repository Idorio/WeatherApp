package com.example.weatherapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.repository.WeatherInteractor
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherInteractor: WeatherInteractor, application: Application) : ViewModel() {
    private val _temp = MutableLiveData<WeatherResponse>()
    val temp:LiveData<WeatherResponse> get()=_temp


    val liveDataList = MutableLiveData<List<WeatherModel>>()


    fun getWeather(){


    }

}





