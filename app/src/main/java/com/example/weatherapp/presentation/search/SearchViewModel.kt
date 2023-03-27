package com.example.weatherapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.CityInteractor
import com.example.weatherapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val cityInteractor: CityInteractor
) : ViewModel() {

    private val _nav = SingleLiveEvent<String>()
    val nav: LiveData<String> = _nav

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun enterCity(city: String) {
        try {
            cityInteractor.setCity(city)
            _nav.value = city
        } catch (e: Exception) {
            _error.value = "This city already exist"
        }


    }
}
