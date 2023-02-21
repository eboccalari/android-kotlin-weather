package com.github.eboccalari.weather.mainModule.model

import com.github.eboccalari.weather.common.entities.ForecastBase
import com.github.eboccalari.weather.common.entities.WeatherBase

class MainRepository {

    private val remoteDatabase = RemoteDatabase()

    suspend fun getWeather(lat: Double, lon: Double, appId: String, units: String, lang: String) : WeatherBase =
        remoteDatabase.getCurrentWeatherByCoordinates(lat, lon, appId, units, lang)

    suspend fun getForecast(lat: Double, lon: Double, appId: String, units: String, lang: String) : ForecastBase =
        remoteDatabase.getForecastWeatherByCoordinates(lat, lon, appId, units, lang)
}