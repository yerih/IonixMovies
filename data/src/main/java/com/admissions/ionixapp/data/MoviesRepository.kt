package com.admissions.ionixapp.data

import com.admissions.ionixapp.data.datasource.MovieLocalDataSource
import com.admissions.ionixapp.data.datasource.MovieRemoteDataSource
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.domain.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MoviesRepository constructor(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
) {
    suspend fun getPopularMovies(): Result<List<Movie>> {
        return if(localDataSource.isEmpty()) {
            val result = remoteDataSource.getPopularMovies()
            if(result.isSuccess) localDataSource.saveMovies(result.result!!)
            return result
        }else Result(localDataSource.getAll())
    }
    suspend fun getMovieCredits(id: Int): Result<List<Movie.Cast>> {
        val result = remoteDataSource.getMovieCredits(id)
//        if(result.isSuccess){
//            val movie = localDataSource.findById(id)
//            movie.cast = result.result!!
//            localDataSource.save(movie)
//        }
        return result
    }
    suspend fun getMovieInfo(movie: Movie) = remoteDataSource.getMovieInfo(movie)

    suspend fun getMoviesFromDB() = localDataSource.getAll()
    suspend fun findMovieById(id: Int) = localDataSource.findById(id)
    suspend fun isEmptyDB() = localDataSource.isEmpty()
    suspend fun save(movie: Movie) = localDataSource.save(movie)
    suspend fun saveMovies(movies: List<Movie>) = localDataSource.saveMovies(movies)

}



