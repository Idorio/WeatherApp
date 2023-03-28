package com.example.weatherapp.di

import android.content.Context
import com.example.weatherapp.data.database.dao.WeatherDAO
import com.example.weatherapp.data.database.dao.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideWeatherDatabase(context: Context):WeatherDatabase{
        return WeatherDatabase.getWeatherDatabaseInstance(context)
    }
    @Provides
    fun provideWeatherDAO(weatherDatabase: WeatherDatabase): WeatherDAO {
        return weatherDatabase.getWeatherDAO()

    }


}