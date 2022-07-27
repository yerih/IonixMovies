package com.admissions.ionixapp.common

import com.admissions.ionixapp.data.database.MovieEntity
import com.admissions.ionixapp.domain.Movie


fun List<Movie>.toEntityDB(): List<MovieEntity> = map { it.toEntityDB() }
fun Movie.toEntityDB(): MovieEntity = MovieEntity(
    id, name, biography, publishingDate, imageUrl, favorite
)


fun List<MovieEntity>.toDomainModel(): List<Movie> = map { it.toDomainModel() }
fun MovieEntity.toDomainModel(): Movie =
    Movie(
        id,
        name,
        biography,
        publishingDate,
        imageUrl,
        favorite
    )
