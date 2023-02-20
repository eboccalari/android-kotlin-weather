package com.github.eboccalari.weather.common.utils

import com.github.eboccalari.weather.common.entities.Weather
import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {

    fun getHour(epoch: Long): String = getFormattedTime(epoch, "HH:mm")

    private fun getFormattedTime(epoch: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(epoch)
    }

    fun getWeatherMain(weather: List<Weather>?): String {
        return if (weather.isNullOrEmpty()) "-" else weather[0].main
    }

    fun getWeatherDescription(weather: List<Weather>?): String {
        return if (weather.isNullOrEmpty()) "-" else weather[0].description
    }
}