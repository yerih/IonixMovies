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


data class MovieCreditsResponse(
    val cast: List<Cast>,
) {
    data class Cast(
        val character: String,
        val name: String,
        val original_name: String,
        val profile_path: String
    )
}