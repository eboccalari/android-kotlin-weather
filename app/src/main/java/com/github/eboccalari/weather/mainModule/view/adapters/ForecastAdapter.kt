package com.github.eboccalari.weather.mainModule.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.eboccalari.weather.BR
import com.github.eboccalari.weather.R
import com.github.eboccalari.weather.common.entities.WeatherBase
import com.github.eboccalari.weather.common.interfaces.OnForecastClickListener
import com.github.eboccalari.weather.databinding.ItemWeatherBinding

class ForecastAdapter(private val listener: OnForecastClickListener):
    ListAdapter<WeatherBase, ForecastAdapter.ForecastViewHolder>(DiffForecastCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            binding?.setVariable(BR.result, item)
            binding?.executePendingBindings()
            setListener(item)
        }
    }

    inner class ForecastViewHolder(view: View): ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(weatherBase: WeatherBase){
            binding?.root?.setOnClickListener {
                listener.onClick(weatherBase)
            }
        }
    }

    class DiffForecastCallback(): DiffUtil.ItemCallback<WeatherBase>(){
        override fun areItemsTheSame(oldItem: WeatherBase, newItem: WeatherBase): Boolean = oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: WeatherBase, newItem: WeatherBase): Boolean = oldItem.equals(newItem)
    }

}