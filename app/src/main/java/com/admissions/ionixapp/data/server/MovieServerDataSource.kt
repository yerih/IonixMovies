package com.admissions.ionixapp.data.server

import com.admissions.ionixapp.data.datasource.MovieRemoteDataSource
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.domain.Result
import com.admissions.ionixapp.ui.common.LocationHelper
import retrofit2.HttpException
import javax.inject.Inject


class MovieServerDataSource @Inject constructor(private val locationHelper: LocationHelper) : MovieRemoteDataSource {
    override suspend fun getPopularMovies(): Result<Movie> {
        return try {
            Result(null, Error() )
        }catch (httpExec: HttpException) {
            Result(null, Error())
        }catch (e: Exception) {
            Result(null, Error(e.message))
        }
    }

    override suspend fun getMovieInfo(movie: Movie): Result<Movie> {
        return try {
            Result(null, Error() )
        }catch (httpExec: HttpException) {
            Result(null, Error())
        }catch (e: Exception) {
            Result(null, Error(e.message))
        }
    }


}


