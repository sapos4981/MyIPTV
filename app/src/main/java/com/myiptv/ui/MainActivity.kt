package com.myiptv.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.myiptv.R
import com.myiptv.adapter.PlaylistAdapter
import com.myiptv.viewmodel.PlaylistViewModel

class MainActivity : AppCompatActivity() {
    
    private lateinit var viewModel: PlaylistViewModel
    private lateinit var adapter: PlaylistAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyState: View
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]
        
        setupRecyclerView()
        setupFab()
        observePlaylists()
    }
    
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.playlistsRecyclerView)
        emptyState = findViewById(R.id.emptyState)
        
        adapter = PlaylistAdapter(
            onPlaylistClick = { playlist ->
                val intent = Intent(this, ChannelListActivity::class.java)
                intent.putExtra("PLAYLIST_ID", playlist.id)
                intent.putExtra("PLAYLIST_NAME", playlist.name)
                startActivity(intent)
            },
            onDeleteClick = { playlist ->
                viewModel.deletePlaylist(playlist)
            }
        )
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    
    private fun setupFab() {
        findViewById<FloatingActionButton>(R.id.fabAddPlaylist).setOnClickListener {
            startActivity(Intent(this, AddPlaylistActivity::class.java))
        }
    }
    
    private fun observePlaylists() {
        viewModel.playlists.observe(this) { playlists ->
            adapter.submitList(playlists)
            
            if (playlists.isEmpty()) {
                recyclerView.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                emptyState.visibility = View.GONE
            }
        }
    }
}
