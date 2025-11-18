package com.myiptv.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.myiptv.R
import com.myiptv.viewmodel.PlaylistViewModel

class AddPlaylistActivity : AppCompatActivity() {
    
    private lateinit var viewModel: PlaylistViewModel
    private lateinit var nameEditText: TextInputEditText
    private lateinit var urlEditText: TextInputEditText
    private lateinit var addButton: Button
    private lateinit var cancelButton: Button
    private lateinit var progressBar: ProgressBar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_playlist)
        
        viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]
        
        nameEditText = findViewById(R.id.nameEditText)
        urlEditText = findViewById(R.id.urlEditText)
        addButton = findViewById(R.id.addButton)
        cancelButton = findViewById(R.id.cancelButton)
        progressBar = findViewById(R.id.progressBar)
        
        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val url = urlEditText.text.toString()
            
            if (name.isBlank() || url.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            setLoading(true)
            
            viewModel.addPlaylist(name, url) { success, error ->
                runOnUiThread {
                    setLoading(false)
                    
                    if (success) {
                        Toast.makeText(this, "Playlist added successfully", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Error: ${error ?: "Unknown error"}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        
        cancelButton.setOnClickListener {
            finish()
        }
    }
    
    private fun setLoading(loading: Boolean) {
        addButton.isEnabled = !loading
        cancelButton.isEnabled = !loading
        nameEditText.isEnabled = !loading
        urlEditText.isEnabled = !loading
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }
}
