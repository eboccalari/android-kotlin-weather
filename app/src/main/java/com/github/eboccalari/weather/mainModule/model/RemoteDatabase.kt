package com.github.eboccalari.weather.mainModule.model

import com.github.eboccalari.weather.common.data.WeatherService
import com.github.eboccalari.weather.common.entities.ForecastBase
import com.github.eboccalari.weather.common.entities.WeatherBase
import com.github.eboccalari.weather.common.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatabase {

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherService = retrofit.create(WeatherService::class.java)

    suspend fun getCurrentWeatherByCoordinates(lat: Double, lon: Double, appId: String, units: String, lang: String) : WeatherBase =
        withContext(Dispatchers.IO){
            weatherService.getWeatherByCoordinadates(lat, lon, appId, units, lang)
        }

    suspend fun getForecastWeatherByCoordinates(lat: Double, lon: Double, appId: String, units: String, lang: String) : ForecastBase =
        withContext(Dispatchers.IO){
            weatherService.getForecastByCoordinadates(lat, lon, appId, units, lang)
        }
}