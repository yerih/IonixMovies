package com.admissions.ionixapp.common

import com.admissions.ionixapp.data.database.MovieEntity
import com.admissions.ionixapp.data.server.GetPopularMoviesResponse
import com.admissions.ionixapp.data.server.MovieCreditsResponse
import com.admissions.ionixapp.data.server.MoviesService
import com.admissions.ionixapp.domain.Movie


fun List<Movie>.toEntityDB(): List<MovieEntity> = map { it.toEntityDB() }
fun Movie.toEntityDB(): MovieEntity = MovieEntity(id, original_title, overview, poster_path, release_date, title)


fun List<MovieEntity>.toDomainModel(): List<Movie> = map { it.toDomainModel() }
fun MovieEntity.toDomainModel(): Movie = Movie(id, original_title, overview, poster_path, release_date, title)

fun GetPopularMoviesResponse.Result.asMovie(): Movie = Movie(id, original_title, overview, "https://image.tmdb.org/t/p/w185/$poster_path?api_key=${MoviesService.apiKey}", release_date, title, mutableListOf())
fun List<GetPopularMoviesResponse.Result>.asMovies(): List<Movie> = map { it.asMovie() }

fun MovieCreditsResponse.Cast.asMovieCast(): Movie.Cast = Movie.Cast(character, name, original_name, profile_path)
fun List<MovieCreditsResponse.Cast>.asMovieCasts(): List<Movie.Cast> = map { it.asMovieCast() }