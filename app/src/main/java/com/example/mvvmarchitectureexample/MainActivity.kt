package com.example.mvvmarchitectureexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitectureexample.Model.WeatherResponse
import com.example.mvvmarchitectureexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Get Weather
        getWeather("Passaic")
    }

    private fun setData(it: WeatherResponse) {
        //Setting Data to the UI Screen
        binding.textView.text = it.name
    }

    //Function to get weather info according to the user entered data
    private fun getWeather(
        string: String
    ) {

        mainActivityViewModel.getWeatherInfo(
            string
        )!!.observe(this, Observer {
            if (it != null) {
                setData(it)
            }
        })

    }
}