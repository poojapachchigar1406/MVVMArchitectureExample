package com.example.mvvmarchitectureexample.Retrofit

import com.example.mvvmarchitectureexample.Model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // API for weather info with search query
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") location: String?,
        @Query("appid") apiKey: String
    ): Call<WeatherResponse>
}