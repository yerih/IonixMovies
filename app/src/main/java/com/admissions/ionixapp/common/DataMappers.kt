package com.admissions.ionixapp.common

import com.admissions.ionixapp.data.database.MovieEntity
import com.admissions.ionixapp.data.server.GetPopularMoviesResponse
import com.admissions.ionixapp.domain.Movie


fun List<Movie>.toEntityDB(): List<MovieEntity> = map { it.toEntityDB() }
fun Movie.toEntityDB(): MovieEntity = MovieEntity(fullTitle, genres, id, image, plot, releaseState, stars, title, year)


fun List<MovieEntity>.toDomainModel(): List<Movie> = map { it.toDomainModel() }
fun MovieEntity.toDomainModel(): Movie = Movie(fullTitle, genres, id, image, plot, releaseState, stars, title, year)

fun GetPopularMoviesResponse.Item.asMovie(): Movie = Movie(fullTitle, genres, id, image, plot, releaseState, stars, title, year)
fun List<GetPopularMoviesResponse.Item>.asMovies(): List<Movie> = map { it.asMovie() }