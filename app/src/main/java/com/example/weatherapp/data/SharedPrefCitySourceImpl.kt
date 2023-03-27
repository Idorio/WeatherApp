package com.example.weatherapp.data

import android.content.SharedPreferences

class SharedPrefCitySourceImpl(
    private val pref: SharedPreferences
) : ICitySource {
    companion object{
        private const val CITY_KEY = "city_key"
    }
    override fun getCity(): String {
        return pref.getString(CITY_KEY, "") ?: ""
    }

    override fun setCity(city: String) {
        pref.edit().putString(CITY_KEY, city).apply()
    }
}