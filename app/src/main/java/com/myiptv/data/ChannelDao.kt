package com.myiptv.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ChannelDao {
    @Query("SELECT * FROM channels WHERE playlistId = :playlistId ORDER BY name ASC")
    fun getChannelsByPlaylist(playlistId: Long): LiveData<List<Channel>>
    
    @Query("SELECT * FROM channels WHERE isFavorite = 1 ORDER BY name ASC")
    fun getFavoriteChannels(): LiveData<List<Channel>>
    
    @Query("SELECT * FROM channels WHERE playlistId = :playlistId AND name LIKE '%' || :query || '%' ORDER BY name ASC")
    fun searchChannels(playlistId: Long, query: String): LiveData<List<Channel>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(channels: List<Channel>)
    
    @Update
    suspend fun update(channel: Channel)
    
    @Query("DELETE FROM channels WHERE playlistId = :playlistId")
    suspend fun deleteByPlaylist(playlistId: Long)
    
    @Query("SELECT DISTINCT `group` FROM channels WHERE playlistId = :playlistId AND `group` IS NOT NULL ORDER BY `group` ASC")
    fun getGroups(playlistId: Long): LiveData<List<String>>
}
