package com.example.weatherapp.data

import com.example.weatherapp.domain.ICityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val source: ICitySource
): ICityRepository {
    override fun getCity(): String {
        return source.getCity()
    }

    override fun setCity(city: String) {
        return source.setCity(city)
    }
}