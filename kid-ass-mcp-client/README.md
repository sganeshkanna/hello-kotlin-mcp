# Kid Assignment MCP Client (`kid-ass-mcp-client`)

The **Kid Assignment MCP Client** is a Kotlin client application demonstrating how to connect to a remote MCP Server over **Server-Sent Events (SSE)** using the official **Kotlin MCP SDK**.

---

## 🚀 Commands

### Build Project
```bash
./gradlew build
# or: gradle build
```

### Run Client
```bash
./gradlew runClient
# or: ./gradlew run
# or: gradle runClient
```

> **Note**: Make sure `kid-ass-mcp-server` is running on `http://localhost:3000` before running the client.

---

## 🛠 Tech Stack
- **Kotlin**: 2.1.0
- **JDK**: 21
- **Client Engine**: Ktor Client CIO (with SSE plugin)
- **MCP SDK**: `io.modelcontextprotocol:kotlin-sdk-client:0.7.2`
