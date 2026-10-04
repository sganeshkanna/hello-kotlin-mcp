package com.gk.mcp.server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.sse.*
import io.modelcontextprotocol.kotlin.sdk.*
import io.modelcontextprotocol.kotlin.sdk.server.*

fun main() {
    embeddedServer(Netty, port = 3000) {
        install(SSE)
        
        routing {
            mcp {
                Server(
                    serverInfo = Implementation(name = "kid-ass-mcp-server", version = "1.0.0"),
                    options = ServerOptions(
                        capabilities = ServerCapabilities(
                            tools = ServerCapabilities.Tools(listChanged = false)
                        )
                    )
                ).apply {
                    // TODO: Register your "create_show_and_tell" tool here!
                    addTool(
                        name = "create_show_and_tell",
                        description = "Generates 5-6 simple speech points for a child's Show and Tell school assignment."
                    ) { request ->
                        val topic = request.arguments["topic"]?.toString() ?: "My Favorite Toy"
                        
                       // Fetch live content dynamically
                    
                       
                        val dynamicScript = fetchDynamicContentFromWeb(topic)
                        // We will build the logic here together!
                        CallToolResult(
                            content = listOf(
                                TextContent(text = dynamicScript)
                            )
                        )
                    }
                }
            }
        }
    }.start(wait = true)
}

fun generateChildFriendlyScript(topic: String): String {
    return """
        📋 Show and Tell Assignment Guide
        Topic: $topic
        
        Here are 5 simple points to say:
        1. Hello teachers and friends! Today I am talking about $topic.
        2. I chose this because it is very special and interesting to me.
        3. One cool thing about it is how it works or what it looks like.
        4. I love playing with / learning about it every single day.
        5. Thank you everyone! Do you have any questions?
    """.trimIndent()
}