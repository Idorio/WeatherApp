package com.example.weatherapp.domain

interface ICityRepository {
    fun getCity(): String
    fun setCity(city: String)
}