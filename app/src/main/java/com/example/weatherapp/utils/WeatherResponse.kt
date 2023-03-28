package com.example.weatherapp.utils


import com.example.weatherapp.data.model.WeatherResp
import com.example.weatherapp.domain.model.WeatherModel
import retrofit2.Response

fun weatherResponse(response: Response<WeatherModel>): Resources<WeatherModel> {
    if (response.isSuccessful) {
        response.body()?.let { result ->
            return Resources.Success(result)

        }
    }
    return Resources.Error(response.message())
}

