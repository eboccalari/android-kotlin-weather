package com.github.eboccalari.weather.common.entities

data class Forecast(val dateTime:Long,
                    val humidity: Int,
                    val temperature: Double,
                    val weather: List<Weather>,
                    val pop: Double): WeatherBase(dateTime, humidity, temperature, weather) {
}
