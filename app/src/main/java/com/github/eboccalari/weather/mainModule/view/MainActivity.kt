package com.github.eboccalari.weather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.github.eboccalari.weather.R
import com.github.eboccalari.weather.databinding.ActivityMainBinding
import com.github.eboccalari.weather.mainModule.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupObservers()
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
            it.loaded.observe(this){ isLoaded ->

            }
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch{
            mBinding.viewModel?.getWeatherAndForecast(-35.81051130764848, -61.898497848645015,
                "5896fd3b5049c865396314f6115b3fcd", "metric", "en")
        }
    }
}