package com.github.eboccalari.weather.common.entities

@Deprecated(message = "API openWeather changes")
data class Current(val dateTime:Long,
                   val humidity: Int,
                   val temperature: Double,
                   val weather: List<Weather>,
                   val sunrise: Long) {
}