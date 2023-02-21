package com.github.eboccalari.weather.common.entities

data class ForecastBase(val cod:String, val list: List<WeatherBase>)
