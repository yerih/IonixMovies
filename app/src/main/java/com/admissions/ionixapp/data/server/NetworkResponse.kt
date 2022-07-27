package com.admissions.ionixapp.data.server

data class GetPopularMoviesResponse(
    val errorMessage: String,
    val items: List<Item>
) {
    data class Item(
        val fullTitle: String,
        val genres: String,
        val id: String,
        val image: String,
        val plot: String,
        val releaseState: String,
        val stars: String,
        val title: String,
        val year: String
    )
}

