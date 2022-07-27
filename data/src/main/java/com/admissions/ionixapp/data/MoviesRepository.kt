package com.admissions.ionixapp.data

import com.admissions.ionixapp.data.datasource.MovieLocalDataSource
import com.admissions.ionixapp.data.datasource.MovieRemoteDataSource
import com.admissions.ionixapp.domain.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MoviesRepository constructor(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
) {
    suspend fun getPopularMovies() = remoteDataSource.getPopularMovies()
    suspend fun getMovieInfo(movie: Movie) = remoteDataSource.getMovieInfo(movie)

    suspend fun getMoviesFromDB() = localDataSource.getAll()
    suspend fun findMovieById(id: Int) = localDataSource.findById(id)
    suspend fun isEmptyDB() = localDataSource.isEmpty()
    suspend fun save(movie: Movie) = localDataSource.save(movie)
}



