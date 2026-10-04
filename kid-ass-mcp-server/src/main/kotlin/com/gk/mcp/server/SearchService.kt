package com.gk.mcp.server

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

val httpClient = HttpClient(CIO)

suspend fun fetchDynamicContentFromWeb(topic: String): String {
    return try {
        // 1. Fetch JSON from DuckDuckGo Instant Answer API
        val url = "https://api.duckduckgo.com/?q=${java.net.URLEncoder.encode(topic, "UTF-8")}&format=json"
        val responseBody = httpClient.get(url).bodyAsText()

        // 2. Parse the JSON response to extract the live abstract summary
        val jsonElement = Json.parseToJsonElement(responseBody)
        val abstractText = jsonElement.jsonObject["AbstractText"]?.jsonPrimitive?.content 
            ?: "It is a wonderful and fascinating topic to explore."

        // 3. Dynamically weave the real-world fact into the speech script!
        """
            🌟 Live Fact-Based Show & Tell: $topic
            
            1. Hello teachers and friends! Today I am excited to share facts about $topic.
            2. Here is what I learned from my research: $abstractText
            3. I think this is super interesting because it teaches us how things work in our world.
            4. I loved learning about it and sharing it with everyone here today.
            5. Thank you for listening! Does anyone have a question about $topic?
        """.trimIndent()
        
    } catch (e: Exception) {
        // Fallback if offline or parsing fails
        """
            🌟 Show & Tell Speech: $topic
            
            1. Hello friends! Today I am talking about $topic.
            2. It is an amazing topic that I love learning about every day.
            3. Thank you for listening, and do you have any questions?
        """.trimIndent()
    }
}