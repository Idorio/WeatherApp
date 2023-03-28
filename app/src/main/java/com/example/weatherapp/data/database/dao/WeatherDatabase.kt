package com.example.weatherapp.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.data.database.dao.model.ForecastDayDBModel
import com.example.weatherapp.data.database.dao.model.WeatherDBModel

@Database(
    entities = [WeatherDBModel::class, ForecastDayDBModel::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDAO(): WeatherDAO

    abstract fun getForecastDayDAO(): ForecastDayDAO

    companion object {
        private const val DATABASE_NAME = "DATABASE_NAME"
        private var DB_INSTANCE: WeatherDatabase? = null

        fun getWeatherDatabaseInstance(context: Context): WeatherDatabase {

            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .build()
                .also { DB_INSTANCE = it }
        }
    }

}