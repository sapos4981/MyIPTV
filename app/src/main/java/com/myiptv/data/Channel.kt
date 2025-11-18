package com.myiptv.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val url: String,
    val logo: String? = null,
    val group: String? = null,
    val playlistId: Long,
    val isFavorite: Boolean = false
)
