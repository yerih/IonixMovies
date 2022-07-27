package com.admissions.ionixapp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.admissions.ionixapp.common.log
import com.bumptech.glide.Glide


@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String?){
    url?.let { Glide.with(context).load(url).into(this) }
}