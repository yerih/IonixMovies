package com.admissions.ionixapp.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.admissions.ionixapp.R
import com.admissions.ionixapp.databinding.ItemMovieBinding
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.common.basicDiffUtil
import com.admissions.ionixapp.common.inflate

class MoviesAdapter(
    private val listener: (Movie) -> Unit
) : ListAdapter<Movie, MoviesAdapter.ViewHolder>(
    basicDiffUtil { old, new -> old.id == new.id }) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)
        fun bind(movie: Movie){ binding.movie = movie }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(parent.inflate(R.layout.item_movie, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }
}



