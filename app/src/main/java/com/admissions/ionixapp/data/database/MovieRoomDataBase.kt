package com.admissions.ionixapp.data.database

import com.admissions.ionixapp.common.toDomainModel
import com.admissions.ionixapp.data.datasource.MovieLocalDataSource
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.common.toEntityDB
import javax.inject.Inject


class MovieRoomDataBase @Inject constructor(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getAll(): List<Movie> = movieDao.getAll().map { it.toDomainModel() }
    override suspend fun findById(id: Int): Movie = movieDao.findById(id).toDomainModel()
    override suspend fun isEmpty(): Boolean = movieDao.getAll().isEmpty()
    override suspend fun save(movie: Movie) = movieDao.insertMovie(movie.toEntityDB())

}

