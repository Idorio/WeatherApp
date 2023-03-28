package com.example.weatherapp.data


import com.example.weatherapp.data.database.dao.ForecastDayDAO
import com.example.weatherapp.data.database.dao.WeatherDAO
import com.example.weatherapp.data.database.dao.model.ForecastDayDBModel
import com.example.weatherapp.data.database.dao.model.WeatherDBModel
import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.data.service.model.WeatherModel
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.model.ForecastDayEntity
import com.example.weatherapp.domain.model.WeatherEntity
import com.example.weatherapp.utils.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val weatherDAO: WeatherDAO,
    private val forecastDayDAO: ForecastDayDAO
) : WeatherRepository {
    override suspend fun getWeather(city: String): Resources<WeatherEntity> {
        var result: Resources<WeatherEntity> = Resources.Loading()
        withContext(Dispatchers.IO) {
            kotlin.runCatching {
                weatherResponse(apiService.getWeather(city, "7ffea88483fb4e648a360906232403", 4))
            }
                .onSuccess {
                    result = onWeatherSuccess(city, it)
                }
                .onFailure {
                    result = onWeatherSuccess(city, Resources.Error(it.message ?: "Unexpected error"))
                }
        }
        return result
    }

    private fun onWeatherSuccess(city: String, model: Resources<WeatherModel>): Resources<WeatherEntity> {
        var result = model.map()
        if (result is Resources.Success) {
            val weather = result.data.map()
            val forecastDay = result.data.forecast.map { it.map(weather.city) }
            weatherDAO.insertWeatherEntity(result.data.map())
            forecastDayDAO.deleteForecastDay(weather.city)
            forecastDay.forEach { day ->
                forecastDayDAO.insertForecastDay(day)
            }
        }else {
            runCatching {
                val weatherDb = weatherDAO.getWeatherEntity(city)
                val forecastDayList = forecastDayDAO.getForecastDay(city)
                Pair(weatherDb, forecastDayList)
            }
                .onSuccess {
                    val (weatherDb, forecastDayList) = it
                    result = Resources.Success(
                        WeatherEntity(
                            city = weatherDb.city,
                            lastUpdated = weatherDb.lastUpdated,
                            temp_c = weatherDb.temp_c,
                            icon = weatherDb.icon,
                            text = weatherDb.text,
                            forecast = forecastDayList
                                .map { dbModel ->
                                    ForecastDayEntity(
                                        date = dbModel.date,
                                        maxtemp_c = dbModel.maxtemp_c,
                                        mintemp_c = dbModel.mintemp_c,
                                        icon = dbModel.icon,
                                        text = dbModel.text
                                    )
                                }
                        )
                    )
                }
        }
        return result
    }


//    override suspend fun showWeather(city: String): List<WeatherEntity> {
//        return withContext(Dispatchers.IO) {
//            weatherDAO.getWeatherEntity()
//        }
//    }

    private fun weatherResponse(response: Response<WeatherModel>): Resources<WeatherModel> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resources.Success(result)

            }
        }
        return Resources.Error(response.message())
    }

    private fun Resources<WeatherModel>.map(): Resources<WeatherEntity> {
        return when (this) {
            is Resources.Error -> {
                Resources.Error(this.message)
            }
            is Resources.Loading -> {
                Resources.Loading()
            }
            is Resources.Success -> {
                Resources.Success(
                    data = WeatherEntity(
                        lastUpdated = this.data.current.last_updated,
                        city = this.data.location.name,
                        temp_c = this.data.current.temp_c,
                        icon = this.data.current.condition.icon,
                        text = this.data.current.condition.text,
                        forecast = this.data.forecast.forecastday.map { netDay ->
                            ForecastDayEntity(
                                date = netDay.date,
                                maxtemp_c = netDay.day.maxtemp_c,
                                mintemp_c = netDay.day.mintemp_c,
                                icon = netDay.day.condition.icon,
                                text = netDay.day.condition.text
                            )
                        }

                    )
                )
            }
        }
    }

    private fun WeatherEntity.map(): WeatherDBModel {
        return WeatherDBModel(
            city = this.city,
            lastUpdated = this.lastUpdated,
            temp_c = this.temp_c,
            icon = this.icon,
            text = this.text
        )
    }

    private fun ForecastDayEntity.map(city: String): ForecastDayDBModel {
        return ForecastDayDBModel(
            date = this.date,
            maxtemp_c = this.maxtemp_c,
            mintemp_c = this.mintemp_c,
            icon = this.icon,
            text = this.text,
            link_id = city
        )
    }
}
