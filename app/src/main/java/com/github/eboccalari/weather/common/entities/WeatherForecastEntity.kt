package com.github.eboccalari.weather.common.entities
@Deprecated(message = "API openWeather changes")
data class WeatherForecastEntity(val timezone: String, val current: Current, val hourly: List<Forecast>)