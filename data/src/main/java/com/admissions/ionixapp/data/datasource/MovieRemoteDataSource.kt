package com.admissions.ionixapp.data.datasource

import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.domain.Result


interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getMovieInfo(movie: Movie): Result<Movie>
}