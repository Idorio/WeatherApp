package com.example.weatherapp.domain

import javax.inject.Inject

class CityInteractor @Inject constructor(
    private val repository: ICityRepository
) {
    fun getCity(): String {
        return repository.getCity()
    }

    fun setCity(city: String) {
        repository.setCity(city)
    }
}