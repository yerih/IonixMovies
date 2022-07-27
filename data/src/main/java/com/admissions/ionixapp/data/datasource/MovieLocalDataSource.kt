package com.admissions.ionixapp.data.datasource

import com.admissions.ionixapp.domain.Movie


interface MovieLocalDataSource {
    suspend fun getAll(): List<Movie>
    suspend fun findById(id: Int): Movie
    suspend fun isEmpty(): Boolean
    suspend fun save(movie: Movie)
    suspend fun saveMovies(movies: List<Movie>)
}