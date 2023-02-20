package com.github.eboccalari.weather.mainModule.model

import com.github.eboccalari.weather.common.entities.WeatherBase

class MainRepository {

    private val remoteDatabase = RemoteDatabase()

    suspend fun getWeatherAndForecast(lat: Double, lon: Double, appId: String, units: String, lang: String) : WeatherBase =
        remoteDatabase.getWeatherForecastByCoordinates(lat, lon, appId, units, lang)
}