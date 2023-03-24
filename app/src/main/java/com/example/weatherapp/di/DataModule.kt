package com.example.weatherapp.di
import com.example.weatherapp.data.service.ApiService

import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {


    @Binds
   abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    companion object {
        @Provides
        fun providesBaseUrl(): String {
            return BASE_URL
        }



    @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
}