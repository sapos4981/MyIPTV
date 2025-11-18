package com.myiptv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myiptv.R
import com.myiptv.data.Playlist

class PlaylistAdapter(
    private val onPlaylistClick: (Playlist) -> Unit,
    private val onDeleteClick: (Playlist) -> Unit
) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var playlists = listOf<Playlist>()

    fun submitList(newList: List<Playlist>) {
        playlists = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(playlists[position])
    }

    override fun getItemCount() = playlists.size

    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameText: TextView = itemView.findViewById(R.id.playlistName)
        private val urlText: TextView = itemView.findViewById(R.id.playlistUrl)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

        fun bind(playlist: Playlist) {
            nameText.text = playlist.name
            urlText.text = playlist.url
            
            itemView.setOnClickListener { onPlaylistClick(playlist) }
            deleteButton.setOnClickListener { onDeleteClick(playlist) }
        }
    }
}
