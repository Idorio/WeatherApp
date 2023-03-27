package com.example.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.CityInteractor
import com.example.weatherapp.presentation.routes.AppRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cityInteractor: CityInteractor
) : ViewModel() {

    private val _navRoute: MutableLiveData<AppRoutes> = MutableLiveData()
    val navRoute: LiveData<AppRoutes> = _navRoute

    init {
        startRouting()
    }

    fun navigate(route: AppRoutes) {
        _navRoute.value = route
    }

    private fun startRouting() {
        val city = cityInteractor.getCity()
        if(city.isNotBlank()){
            _navRoute.value = AppRoutes.Weather(city)
        } else {
            _navRoute.value = AppRoutes.Search
        }
    }
}