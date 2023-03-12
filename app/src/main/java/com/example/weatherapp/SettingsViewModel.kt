package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


class SettingsViewModel : ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun enterCity(city:String) {
        try {
            _nav.value = Unit
        }catch (e:Exception){
            _error.value = "This city already exist"
        }


    }
}
