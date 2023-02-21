package com.github.eboccalari.weather.common.interfaces

import com.github.eboccalari.weather.common.entities.WeatherBase

interface OnForecastClickListener {

    fun onClick(weatherBase: WeatherBase)

}