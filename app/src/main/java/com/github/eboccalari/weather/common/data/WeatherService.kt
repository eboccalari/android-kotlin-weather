package com.github.eboccalari.weather.common.data

import com.github.eboccalari.weather.common.entities.ForecastBase
import com.github.eboccalari.weather.common.entities.WeatherBase
import com.github.eboccalari.weather.common.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(Constant.CURRENT_WEATHER_PATH)
    suspend fun getWeatherByCoordinadates(
        @Query(Constant.LATITUDE_PARAM) lat: Double,
        @Query(Constant.LONGITUDE_PARAM) lon: Double,
        @Query(Constant.APP_ID_PARAM) appId: String,
        @Query(Constant.UNITS_PARAM) units: String,
        @Query(Constant.LANGUAGE_PARAM) lang: String
    ): WeatherBase

    @GET(Constant.FORECAST_WEATHER_PATH)
    suspend fun getForecastByCoordinadates(
        @Query(Constant.LATITUDE_PARAM) lat: Double,
        @Query(Constant.LONGITUDE_PARAM) lon: Double,
        @Query(Constant.APP_ID_PARAM) appId: String,
        @Query(Constant.UNITS_PARAM) units: String,
        @Query(Constant.LANGUAGE_PARAM) lang: String
    ): ForecastBase
}