package com.example.mvvmarchitectureexample.Model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("base")
    val base: String? = "",
    @SerializedName("visibility")
    val visibility: Int? = 0,
    @SerializedName("dt")
    val dt: Int? = 0,
    @SerializedName("timezone")
    val timezone: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("cod")
    val cod: Int? = 0
)