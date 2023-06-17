package com.example.mvvmarchitectureexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitectureexample.Model.WeatherResponse

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<WeatherResponse>? = null

    fun getWeatherInfo(
        query: String
    ): LiveData<WeatherResponse>? {
        servicesLiveData = MainActivityRepository.getWeatherData(query)
        return servicesLiveData
    }
}