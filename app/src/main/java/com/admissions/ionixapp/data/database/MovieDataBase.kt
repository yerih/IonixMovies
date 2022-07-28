package com.admissions.ionixapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.admissions.ionixapp.data.server.Converters


@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MovieDataBase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
}


