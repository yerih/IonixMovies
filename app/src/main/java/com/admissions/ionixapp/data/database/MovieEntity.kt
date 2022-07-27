package com.admissions.ionixapp.data.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.admissions.ionixapp.domain.Movie
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val biography: String = "",
    val publishingDate: String = "",
    val imageUrl: String = "",
    val favorite: Boolean = false
) : Parcelable
