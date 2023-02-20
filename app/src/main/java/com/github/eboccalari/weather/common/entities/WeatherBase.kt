package com.github.eboccalari.weather.common.entities

open class WeatherBase(val dt:Long,
                  val timezone: Int,
                  val name: String,
                  val main: WeatherMain,
                  val weather: List<Weather>)