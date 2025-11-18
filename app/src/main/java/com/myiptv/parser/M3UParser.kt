package com.myiptv.parser

import com.myiptv.data.Channel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.StringReader

class M3UParser {
    private val client = OkHttpClient()
    
    suspend fun parseFromUrl(url: String, playlistId: Long): List<Channel> = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        
        if (!response.isSuccessful) {
            throw Exception("Failed to download playlist: ${response.code}")
        }
        
        val content = response.body?.string() ?: throw Exception("Empty response")
        parseM3U(content, playlistId)
    }
    
    private fun parseM3U(content: String, playlistId: Long): List<Channel> {
        val channels = mutableListOf<Channel>()
        val reader = BufferedReader(StringReader(content))
        
        var line: String?
        var currentName = ""
        var currentLogo: String? = null
        var currentGroup: String? = null
        
        while (reader.readLine().also { line = it } != null) {
            line?.let { currentLine ->
                when {
                    currentLine.startsWith("#EXTINF:") -> {
                        // Parse channel info
                        currentName = extractChannelName(currentLine)
                        currentLogo = extractAttribute(currentLine, "tvg-logo")
                        currentGroup = extractAttribute(currentLine, "group-title")
                    }
                    currentLine.isNotBlank() && !currentLine.startsWith("#") -> {
                        // This is the URL line
                        if (currentName.isNotEmpty()) {
                            channels.add(
                                Channel(
                                    name = currentName,
                                    url = currentLine.trim(),
                                    logo = currentLogo,
                                    group = currentGroup,
                                    playlistId = playlistId
                                )
                            )
                        }
                        currentName = ""
                        currentLogo = null
                        currentGroup = null
                    }
                }
            }
        }
        
        return channels
    }
    
    private fun extractChannelName(line: String): String {
        val commaIndex = line.lastIndexOf(',')
        return if (commaIndex != -1 && commaIndex < line.length - 1) {
            line.substring(commaIndex + 1).trim()
        } else {
            "Unknown Channel"
        }
    }
    
    private fun extractAttribute(line: String, attribute: String): String? {
        val regex = """$attribute="([^"]*)"""".toRegex()
        return regex.find(line)?.groupValues?.get(1)
    }
}
