package com.example.weatherapp.di

import android.content.Context
import android.provider.ContactsContract.Contacts
import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.utils.Constants
import com.example.weatherapp.utils.Constants.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

}