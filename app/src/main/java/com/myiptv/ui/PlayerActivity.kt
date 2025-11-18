package com.myiptv.ui

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.myiptv.R

class PlayerActivity : AppCompatActivity() {
    
    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )
        
        setContentView(R.layout.activity_player)
        
        playerView = findViewById(R.id.playerView)
        
        val channelUrl = intent.getStringExtra("CHANNEL_URL") ?: ""
        val channelName = intent.getStringExtra("CHANNEL_NAME") ?: ""
        
        initializePlayer(channelUrl)
    }
    
    private fun initializePlayer(url: String) {
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            playerView.player = exoPlayer
            
            val mediaItem = MediaItem.fromUri(url)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
            
            exoPlayer.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    when (state) {
                        Player.STATE_BUFFERING -> {
                            // Show loading
                        }
                        Player.STATE_READY -> {
                            // Hide loading
                        }
                        Player.STATE_ENDED -> {
                            finish()
                        }
                    }
                }
            })
        }
    }
    
    override fun onStop() {
        super.onStop()
        player?.pause()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
