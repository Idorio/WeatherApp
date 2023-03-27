package com.example.weatherapp.domain.model

import androidx.annotation.Keep

@Keep
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)