package com.example.weatherapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.database.dao.model.ForecastDayDBModel

@Dao
interface ForecastDayDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertForecastDay(forecastDay: ForecastDayDBModel)

    @Query("SELECT * FROM ForecastDayDBModel WHERE link_id =:linkId")
    fun getForecastDay(linkId: String): List<ForecastDayDBModel>

    @Query("DELETE FROM ForecastDayDBModel WHERE link_id =:linkId")
    fun deleteForecastDay(linkId: String)

}