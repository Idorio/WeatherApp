package com.example.weatherapp.data.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.weatherapp.data.database.WeatherEntity
import com.example.weatherapp.domain.model.WeatherModel
import retrofit2.Response

@Dao
interface WeatherDAO {

    @Insert(onConflict = IGNORE)
    fun insertWeatherEntity(weatherEntity: WeatherEntity)

    @Query("SELECT * From WeatherEntity")
    fun getWeatherEntity(): Response<WeatherModel>

    @Query("SELECT (SELECT COUNT(*) FROM weatherEntity) !=0")
    fun doesWeatherEntityExist(): Boolean

}