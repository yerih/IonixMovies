package com.admissions.ionixapp.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao{
    @Query("SELECT * FROM MovieEntity")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    fun findById(id: Int) : MovieEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

}


