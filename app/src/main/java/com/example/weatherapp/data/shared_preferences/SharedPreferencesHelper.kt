package com.example.weatherapp.data.shared_preferences

import android.content.SharedPreferences


class SharedPreferencesHelper(private val sharedPreferences: SharedPreferences) {


    fun saveCityName(name: String?){
        sharedPreferences.edit().putString(CITY_NAME, name).apply()
    }





    companion object{
        private const val CITY_NAME = "CITY_NAME"

    }

}



