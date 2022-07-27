package com.admissions.ionixapp.ui.main

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.admissions.ionixapp.domain.Movie


@BindingAdapter("items")
fun RecyclerView.setItems(movies: List<Movie>?){
    movies?.let { (adapter as? MoviesAdapter)?.submitList(it) }
}

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean) = if(visible) visibility = View.VISIBLE
else visibility = View.GONE



