package com.github.eboccalari.weather.common.entities

open class WeatherBase(dateTime:Long,
                  humidity: Int,
                  temperature: Double,
                  weather: List<Weather>)