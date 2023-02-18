package com.github.eboccalari.weather.common.entities

data class Current(val dateTime:Long,
                   val humidity: Int,
                   val temperature: Double,
                   val weather: List<Weather>,
                   val sunrise: Long): WeatherBase(dateTime, humidity, temperature, weather) {
}