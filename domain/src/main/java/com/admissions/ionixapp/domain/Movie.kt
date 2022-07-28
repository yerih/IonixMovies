package com.admissions.ionixapp.domain

data class Movie(
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    var cast: List<Cast>? = null,
){
    data class Cast(
        val character: String,
        val name: String,
        val original_name: String,
        val profile_path: String
    )
}