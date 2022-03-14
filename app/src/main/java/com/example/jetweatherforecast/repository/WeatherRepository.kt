package com.example.jetweatherforecast.repository

import android.util.Log
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.model.WeatherObject
import com.example.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Exception> = try {
        val response = api.getWeather(query = cityQuery)
        Log.d("PEDRO", "getWeather: ${response.city.country}")
        DataOrException(data = response)
    } catch (exception: Exception) {
        Log.d("PEDRO", "getWeather: ${exception}")
        DataOrException(e = exception)
    }


}