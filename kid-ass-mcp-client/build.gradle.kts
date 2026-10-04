plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "com.gk.mcp.client"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    
    // Core Ktor client components
    implementation("io.ktor:ktor-client-core:3.0.0")
    implementation("io.ktor:ktor-client-cio:3.0.0")
    
    // Official MCP SDK Client
    implementation("io.modelcontextprotocol:kotlin-sdk-client:0.7.2")
    
    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.12")
}

application {
    mainClass.set("com.gk.mcp.client.MainKt")
}


tasks.register<JavaExec>("runClient") {
    group = "application"
    description = "Runs the MCP Client"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.gk.mcp.client.MainKt")
}