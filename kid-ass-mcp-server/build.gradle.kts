plugins{
    kotlin("jvm") version "2.1.0"
    application
}

group = "com.gk.mcp.server"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
    
    // Ktor Server components
    implementation("io.ktor:ktor-server-core:3.0.3")
    implementation("io.ktor:ktor-server-netty:3.0.3")
    implementation("io.ktor:ktor-server-sse:3.0.3")
    
    // Ktor Client components
    implementation("io.ktor:ktor-client-core:3.0.0")
    implementation("io.ktor:ktor-client-cio:3.0.0")
    implementation("io.ktor:ktor-client-content-negotiation:3.0.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    
    // Correct official MCP SDK Server artifact
    implementation("io.modelcontextprotocol:kotlin-sdk-server:0.7.2")
    
    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.12")
}

application {
    mainClass.set("com.gk.mcp.server.MainKt")
}

tasks.register<JavaExec>("runServer") {
    group = "application"
    description = "Runs the MCP Server"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.gk.mcp.server.MainKt")
}