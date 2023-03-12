package com.example.weatherapp.di

import com.example.weatherapp.domain.WeatherInteractor
import com.example.weatherapp.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideWeatherInteractor(
        weatherRepository: WeatherRepository
    ): WeatherInteractor {
        return WeatherInteractor(weatherRepository)
    }

}