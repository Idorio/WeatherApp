package com.example.weatherapp.data

interface ICitySource {
    fun getCity(): String
    fun setCity(city: String)
}