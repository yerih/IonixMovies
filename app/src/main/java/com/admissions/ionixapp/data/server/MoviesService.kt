package com.admissions.ionixapp.data.server


import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


interface MoviesService {

    companion object{
        private const val urlBase = "https://imdb-api.com/en/API/InTheaters/"
        private const val apiKey = "3721d069f6msh0c5a39eb6075f50p1943b3jsn7e3ed9ab083c"

        private val okHttpClient1: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
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


}


