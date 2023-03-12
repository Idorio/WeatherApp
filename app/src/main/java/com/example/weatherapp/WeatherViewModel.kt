package com.example.weatherapp


import androidx.lifecycle.*
import com.example.weatherapp.domain.WeatherInteractor
import com.example.weatherapp.model.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherInteractor) :
    ViewModel() {
    private val _temp = MutableLiveData<List<WeatherModel>>()
    val temp: LiveData<List<WeatherModel>> get() = _temp

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> get() = _error


    fun getWeather() = viewModelScope.launch {
            try {
                val current = weatherRepository.getWeather()
                _temp.value = current
            }catch (e: Exception){
                _error.value = e.message.toString()
            }

            }
        }









