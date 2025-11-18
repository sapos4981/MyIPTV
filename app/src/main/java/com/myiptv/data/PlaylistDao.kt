package com.myiptv.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlists ORDER BY addedDate DESC")
    fun getAllPlaylists(): LiveData<List<Playlist>>
    
    @Insert
    suspend fun insert(playlist: Playlist): Long
    
    @Delete
    suspend fun delete(playlist: Playlist)
    
    @Query("SELECT * FROM playlists WHERE id = :id")
    suspend fun getPlaylistById(id: Long): Playlist?
}
