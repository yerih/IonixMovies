package com.admissions.ionixapp.data.server


import com.google.gson.GsonBuilder
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface MoviesService {

    companion object{
        private const val urlBase = "https://api.themoviedb.org/3/"
        const val apiKey = "d30e1f350220f9aad6c4110df385d380"
        private const val GET_POPULAR_MOVIES = "discover/movie?sort_by=popularity.desc"
        private const val GET_CREDITS = "/movie/{movie_id}/credits"

        private val okHttpClient1: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .addInterceptor( OkHttpProfilerInterceptor())
            .build()

        private val gson = GsonBuilder().setLenient().create()
        private val retrofit = getRetrofit()
        private fun getRetrofit(baseURL: String = urlBase, client: OkHttpClient = okHttpClient1): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseURL)
                .build()
        }

        val service: MoviesService = retrofit.create()
    }


    @GET(GET_POPULAR_MOVIES)
    suspend fun getPopularMovies(@Query("api_key")api_key: String = apiKey): GetPopularMoviesResponse

    @GET(GET_CREDITS)
    suspend fun getMovieCredits(@Path("movie_id") movieId: Int,@Query("api_key")api_key: String = apiKey): MovieCreditsResponse


}

