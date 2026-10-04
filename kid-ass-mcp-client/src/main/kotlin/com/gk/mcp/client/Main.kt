package com.gk.mcp.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.sse.*
import io.modelcontextprotocol.kotlin.sdk.*
import io.modelcontextprotocol.kotlin.sdk.client.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val httpClient = HttpClient(CIO) {
        install(SSE)
    }

    val transport = SseClientTransport(
        client = httpClient,
        urlString = "http://localhost:3000"
    )

    val client = Client(
        clientInfo = Implementation(name = "kid-ass-mcp-client", version = "1.0.0")
    )

    println("Connecting to Kid Assignment MCP Server...")
    client.connect(transport)

    println("\nCalling 'create_show_and_tell' tool...")
    val result = client.callTool(
        name = "create_show_and_tell",
        arguments = mapOf("topic" to "Road Transport")
    )

    result?.content?.forEach { content ->
        if (content is TextContent) {
            println("\n--- Server Response ---\n${content.text}")
        }
    }

    client.close()
    httpClient.close()
}