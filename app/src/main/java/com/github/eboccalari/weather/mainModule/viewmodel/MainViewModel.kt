package com.github.eboccalari.weather.mainModule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.eboccalari.weather.R
import com.github.eboccalari.weather.common.entities.ForecastBase
import com.github.eboccalari.weather.common.entities.WeatherBase
import com.github.eboccalari.weather.common.entities.WeatherForecastEntity
import com.github.eboccalari.weather.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _result = MutableLiveData<WeatherBase>()
    val result: LiveData<WeatherBase>
    get() = _result

    private val _forecastResult = MutableLiveData<ForecastBase>()
    val forecastResult: LiveData<ForecastBase>
        get() = _forecastResult

    private val _snackbarMessage = MutableLiveData<Int>()
    val snackbarMessage: LiveData<Int>
    get() = _snackbarMessage

    private val _loaded = MutableLiveData<Boolean>()
    val loaded: LiveData<Boolean>
    get() = _loaded

    private val mainRepository = MainRepository()

    suspend fun getWeather(lat: Double, lon: Double, appId: String, units: String, lang: String){
        viewModelScope.launch{
            try {
                _loaded.value = false
                _result.value = mainRepository.getWeather(lat, lon, appId, units, lang)
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _snackbarMessage.value = R.string.main_server_error
            }finally {
                _loaded.value = true
            }
        }
    }

    suspend fun getForecast(lat: Double, lon: Double, appId: String, units: String, lang: String){
        viewModelScope.launch{
            try {
                _loaded.value = false
                _forecastResult.value = mainRepository.getForecast(lat, lon, appId, units, lang)
            }catch (e: java.lang.Exception){
                e.printStackTrace()
                _snackbarMessage.value = R.string.main_server_error
            }finally {
                _loaded.value = true
            }
        }
    }

}