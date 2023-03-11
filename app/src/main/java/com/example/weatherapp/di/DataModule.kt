package com.example.weatherapp.di

import com.example.weatherapp.data.service.ApiService

import com.example.weatherapp.utils.Constants.BASE_URL
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


    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

        @Provides
        fun providesBaseUrl(): String {
            return BASE_URL
        }

        @Provides
        fun provideRetrofit(
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}


//    @Provides
//    @Singleton
//    fun provideRetrofitInstance(): ApiService {
//        return  Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//
//    }