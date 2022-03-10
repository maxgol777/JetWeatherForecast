package com.example.jetweatherforecast.repository

import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.WeatherObject
import com.example.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(cityQuery: String): DataOrException<WeatherObject, Exception> = try {
        val response = api.getWeather(query = cityQuery)
        DataOrException(data = response)
    } catch (exception: Exception) {
        DataOrException(e = exception)
    }


}