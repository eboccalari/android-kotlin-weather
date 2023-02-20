package com.github.eboccalari.weather.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun isGone(view: View, loaded: Boolean){
    view.visibility = if(loaded) View.GONE else View.VISIBLE
}