# Kid Assignment MCP Server (`kid-ass-mcp-server`)

The **Kid Assignment MCP Server** is a Kotlin server built with **Ktor** and the official **Kotlin MCP SDK**. It exposes the `create_show_and_tell` tool over SSE, which queries real-time factual data from external web APIs (DuckDuckGo Instant Answer API) and generates structured speaking scripts for kids' school assignments.

---

## 🚀 Commands

### Build Project
```bash
./gradlew build
# or: gradle build
```

### Run Server
```bash
./gradlew runServer
# or: ./gradlew run
# or: gradle runServer
```

The server runs locally at `http://localhost:3000`.

---

## 🛠 Tech Stack
- **Kotlin**: 2.1.0
- **JDK**: 21
- **Server Framework**: Ktor 3.0.3 (Netty engine, SSE routing)
- **MCP SDK**: `io.modelcontextprotocol:kotlin-sdk-server:0.7.2`
- **HTTP Client**: Ktor Client CIO (for external Web API requests)
- **JSON Parser**: `kotlinx.serialization`
