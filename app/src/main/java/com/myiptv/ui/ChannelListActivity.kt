package com.myiptv.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.myiptv.R
import com.myiptv.adapter.ChannelAdapter
import com.myiptv.viewmodel.PlaylistViewModel

class ChannelListActivity : AppCompatActivity() {
    
    private lateinit var viewModel: PlaylistViewModel
    private lateinit var adapter: ChannelAdapter
    private var playlistId: Long = 0
    private var playlistName: String = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel_list)
        
        playlistId = intent.getLongExtra("PLAYLIST_ID", 0)
        playlistName = intent.getStringExtra("PLAYLIST_NAME") ?: "Channels"
        
        viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]
        
        setupToolbar()
        setupRecyclerView()
        setupSearch()
        loadChannels()
    }
    
    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.title = playlistName
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
    
    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.channelsRecyclerView)
        
        adapter = ChannelAdapter(
            onChannelClick = { channel ->
                val intent = Intent(this, PlayerActivity::class.java)
                intent.putExtra("CHANNEL_URL", channel.url)
                intent.putExtra("CHANNEL_NAME", channel.name)
                startActivity(intent)
            },
            onFavoriteClick = { channel ->
                viewModel.toggleFavorite(channel)
            }
        )
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    
    private fun setupSearch() {
        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString()
                if (query.isEmpty()) {
                    loadChannels()
                } else {
                    searchChannels(query)
                }
            }
        })
    }
    
    private fun loadChannels() {
        viewModel.getChannels(playlistId).observe(this) { channels ->
            adapter.submitList(channels)
        }
    }
    
    private fun searchChannels(query: String) {
        viewModel.searchChannels(playlistId, query).observe(this) { channels ->
            adapter.submitList(channels)
        }
    }
}
