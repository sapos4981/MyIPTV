package com.myiptv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myiptv.R
import com.myiptv.data.Channel

class ChannelAdapter(
    private val onChannelClick: (Channel) -> Unit,
    private val onFavoriteClick: (Channel) -> Unit
) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    private var channels = listOf<Channel>()

    fun submitList(newList: List<Channel>) {
        channels = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_channel, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(channels[position])
    }

    override fun getItemCount() = channels.size

    inner class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logoImage: ImageView = itemView.findViewById(R.id.channelLogo)
        private val nameText: TextView = itemView.findViewById(R.id.channelName)
        private val groupText: TextView = itemView.findViewById(R.id.channelGroup)
        private val favoriteButton: ImageButton = itemView.findViewById(R.id.favoriteButton)

        fun bind(channel: Channel) {
            nameText.text = channel.name
            groupText.text = channel.group ?: ""
            
            channel.logo?.let {
                Glide.with(itemView.context)
                    .load(it)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .into(logoImage)
            }
            
            val favoriteIcon = if (channel.isFavorite) {
                android.R.drawable.star_big_on
            } else {
                android.R.drawable.star_big_off
            }
            favoriteButton.setImageResource(favoriteIcon)
            
            itemView.setOnClickListener { onChannelClick(channel) }
            favoriteButton.setOnClickListener { onFavoriteClick(channel) }
        }
    }
}
