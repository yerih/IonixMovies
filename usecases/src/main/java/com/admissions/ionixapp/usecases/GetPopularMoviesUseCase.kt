package com.admissions.ionixapp.usecases

import com.admissions.ionixapp.data.MoviesRepository
import com.admissions.ionixapp.domain.Movie

class GetPopularMoviesUseCase(
    private val repository: MoviesRepository
){
    suspend fun getMovieById(id: Int) = repository.findMovieById(id)
    suspend fun getMovieInfo(movie: Movie) = repository.getMovieInfo(movie)
    suspend fun getMovieFromDB() = repository.getMoviesFromDB()
    suspend fun getPopularMovies() = repository.getPopularMovies()
    suspend fun isEmptyDB() = repository.isEmptyDB()
    suspend fun save(movie: Movie) = repository.save(movie)
    suspend fun saveMovies(movies: List<Movie>) = repository.saveMovies(movies)
}