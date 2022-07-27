package com.admissions.ionixapp.data.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.admissions.ionixapp.domain.Movie
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,

) : Parcelable