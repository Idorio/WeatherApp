package com.example.weatherapp.data.service.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
): Serializable