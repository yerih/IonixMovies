package com.admissions.ionixapp.data.server

import com.admissions.ionixapp.common.asMovieCasts
import com.admissions.ionixapp.common.asMovies
import com.admissions.ionixapp.common.log
import com.admissions.ionixapp.data.datasource.MovieRemoteDataSource
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.domain.Result
import com.admissions.ionixapp.ui.common.LocationHelper
import retrofit2.HttpException
import javax.inject.Inject


class MovieServerDataSource @Inject constructor(private val locationHelper: LocationHelper) : MovieRemoteDataSource {
    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val response = MoviesService.service.getPopularMovies()
            Result(response.results.asMovies(), null)
        }catch (httpExec: HttpException) {
            val error = httpExec.message.toString()
            log("error http = $error")
            Result(null, Error())
        }catch (e: Exception) {
            val error = e.message.toString()
            log("error = $error")
            Result(null, Error(e.message))
        }
    }

    override suspend fun getMovieCredits(id: Int): Result<List<Movie.Cast>> {
        return try {
            val response = MoviesService.service.getMovieCredits(id)
            Result(response.cast.asMovieCasts(), null)
        }catch (httpExec: HttpException) {
            val error = httpExec.message.toString()
            log("error http = $error")
            Result(null, Error())
        }catch (e: Exception) {
            val error = e.message.toString()
            log("error = $error")
            Result(null, Error(e.message))
        }
    }

    override suspend fun getMovieInfo(movie: Movie): Result<Movie> {
        return Result(null, Error("not available") )
    }


}


