package com.example.mvvmarchitectureexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmarchitectureexample.Constants.API_KEY
import com.example.mvvmarchitectureexample.Model.WeatherResponse
import com.example.mvvmarchitectureexample.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val weatherResponseMutableLiveData = MutableLiveData<WeatherResponse>()

    //Calling the API for fetching weather info using search query and handling success and failure cases
    fun getWeatherData(
        query: String
    ): MutableLiveData<WeatherResponse> {

        val call = RetrofitClient.apiInterface.getWeather(
            query, API_KEY
        )
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("API Error", "Failed to make API call: " + t.message)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                weatherResponseMutableLiveData.value = response.body()
            }
        })

        return weatherResponseMutableLiveData
    }

}