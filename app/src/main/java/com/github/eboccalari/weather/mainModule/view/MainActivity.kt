package com.github.eboccalari.weather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.eboccalari.weather.R
import com.github.eboccalari.weather.common.entities.ForecastBase
import com.github.eboccalari.weather.common.entities.WeatherBase
import com.github.eboccalari.weather.common.interfaces.OnForecastClickListener
import com.github.eboccalari.weather.databinding.ActivityMainBinding
import com.github.eboccalari.weather.mainModule.view.adapters.ForecastAdapter
import com.github.eboccalari.weather.mainModule.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnForecastClickListener {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        val viewModel: MainViewModel by viewModels()
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel
    }

    private fun setupObservers() {
        mBinding.viewModel?.let {
            it.snackbarMessage.observe(this){ snackMessage ->
                Snackbar.make(mBinding.root, snackMessage, Snackbar.LENGTH_LONG).show()
            }
            it.forecastResult.observe(this){forecastBase ->
                mAdapter.submitList(forecastBase.list)
            }
        }
    }

    private fun setupAdapter(){
        mAdapter = ForecastAdapter(this)
    }

    private fun setupRecyclerView(){
        with(mBinding.recyclerView){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.mAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch{
            mBinding.viewModel?.getWeather(-35.81051130764848, -61.898497848645015,
                "5896fd3b5049c865396314f6115b3fcd", "metric", "en")
            mBinding.viewModel?.getForecast(-35.81051130764848, -61.898497848645015,
                "5896fd3b5049c865396314f6115b3fcd", "metric", "en")
        }
    }

    /**
     * OnForecastClickListener
     */
    override fun onClick(forecast: WeatherBase) {
        Snackbar.make(mBinding.root, forecast.name, Snackbar.LENGTH_SHORT).show()
    }
}