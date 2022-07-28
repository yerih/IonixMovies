package com.admissions.ionixapp.data.server

import androidx.room.TypeConverter
import com.admissions.ionixapp.domain.Movie
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<Movie.Cast>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Movie.Cast>::class.java).toList()
}