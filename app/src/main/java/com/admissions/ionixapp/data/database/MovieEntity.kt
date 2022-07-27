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
    val fullTitle: String,
    val genres: String,
    val id: String,
    val image: String,
    val plot: String,
    val releaseState: String,
    val stars: String,
    val title: String,
    val year: String
) : Parcelable