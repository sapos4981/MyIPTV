package com.myiptv.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.myiptv.data.AppDatabase
import com.myiptv.data.Channel
import com.myiptv.data.Playlist
import com.myiptv.parser.M3UParser
import kotlinx.coroutines.launch

class PlaylistViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val playlistDao = database.playlistDao()
    private val channelDao = database.channelDao()
    private val parser = M3UParser()
    
    val playlists: LiveData<List<Playlist>> = playlistDao.getAllPlaylists()
    
    fun addPlaylist(name: String, url: String, onComplete: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val playlist = Playlist(name = name, url = url)
                val playlistId = playlistDao.insert(playlist)
                
                val channels = parser.parseFromUrl(url, playlistId)
                channelDao.insertAll(channels)
                
                onComplete(true, null)
            } catch (e: Exception) {
                onComplete(false, e.message)
            }
        }
    }
    
    fun deletePlaylist(playlist: Playlist) {
        viewModelScope.launch {
            channelDao.deleteByPlaylist(playlist.id)
            playlistDao.delete(playlist)
        }
    }
    
    fun getChannels(playlistId: Long): LiveData<List<Channel>> {
        return channelDao.getChannelsByPlaylist(playlistId)
    }
    
    fun searchChannels(playlistId: Long, query: String): LiveData<List<Channel>> {
        return channelDao.searchChannels(playlistId, query)
    }
    
    fun toggleFavorite(channel: Channel) {
        viewModelScope.launch {
            channelDao.update(channel.copy(isFavorite = !channel.isFavorite))
        }
    }
}
