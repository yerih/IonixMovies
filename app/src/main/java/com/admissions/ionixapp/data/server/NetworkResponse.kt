package com.admissions.ionixapp.data.server

data class GetPopularMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
) {
    data class Result(
        val id: Int,
        val original_title: String,
        val overview: String,
        val poster_path: String,
        val release_date: String,
        val title: String,
    )
}


