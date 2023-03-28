package com.example.weatherapp.data.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.weatherapp.data.database.dao.model.WeatherDBModel
import com.example.weatherapp.data.service.model.WeatherModel

@Dao
interface WeatherDAO {

    @Insert(onConflict = REPLACE)
    fun insertWeatherEntity(weatherEntity: WeatherDBModel)

    @Query("SELECT * FROM WeatherDBModel WHERE city=:city LIMIT 1")
    fun getWeatherEntity(city: String): WeatherDBModel

    @Query("SELECT (SELECT COUNT(*) FROM WeatherDBModel) !=0")
    fun doesWeatherEntityExist(): Boolean

}