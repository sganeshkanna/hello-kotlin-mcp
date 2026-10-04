# Show and Tell MCP Assistant 🎒🤖

A Kotlin-based multi-project repository demonstrating the [Model Context Protocol (MCP)](https://modelcontextprotocol.io) using the official Kotlin SDK. This project consists of an **MCP Server** and an **MCP Client** communicating over **Server-Sent Events (SSE)** to generate structured, fact-rich "Show and Tell" speaking scripts for school assignments.

---

## 📁 Repository Structure

```text
.
├── kid-ass-mcp-server/   # Kotlin MCP Server (Ktor SSE, DuckDuckGo API integration)
├── kid-ass-mcp-client/   # Kotlin MCP Client (Ktor CIO client connecting over SSE)
├── README.md             # Repository overview & quick start guide
└── more_info.md          # Technical implementation details & use case summary
```

---

## ⚡ Prerequisites

- **Java Development Kit (JDK)**: JDK 21 or later
- **Gradle**: 8.x / 9.x (or use included `./gradlew` wrappers)

---

## 🚀 Quick Start & Run Steps

### 1. Build Both Projects

Navigate into each directory and run the Gradle build command:

**Build Server:**
```bash
cd kid-ass-mcp-server
./gradlew build
# or: gradle build
```

**Build Client:**
```bash
cd kid-ass-mcp-client
./gradlew build
# or: gradle build
```

---

### 2. Run the MCP Server

The server runs on `http://localhost:3000` over SSE. Open a terminal window and run:

```bash
cd kid-ass-mcp-server
./gradlew runServer
# or: ./gradlew run
# or: gradle runServer
```

*You should see log output indicating:*
`Responding at http://0.0.0.0:3000`

---

### 3. Run the MCP Client

Open a **second terminal window** while the server is running, and run the client:

```bash
cd kid-ass-mcp-client
./gradlew runClient
# or: ./gradlew run
# or: gradle runClient
```

---

## 📊 Output Example

When the client connects to the server and invokes the `create_show_and_tell` tool for the topic `"Road Transport"`, you will see output like this:

```text
Connecting to Kid Assignment MCP Server...

Calling 'create_show_and_tell' tool...

--- Server Response ---
🌟 Live Fact-Based Show & Tell: "Road Transport"

1. Hello teachers and friends! Today I am excited to share facts about "Road Transport".
2. Here is what I learned from my research: Road transport or road transportation is a type of transport using roads...
3. I think this is super interesting because it teaches us how things work in our world.
4. I loved learning about it and sharing it with everyone here today.
5. Thank you for listening! Does anyone have a question about "Road Transport"?
```

---

## 📖 Additional Documentation

For a detailed breakdown of the use case, architecture diagram, and technical implementation choices, check out [More Info](more_info.md)
