plugins {
    id("java")
}

group = "io.github.dexrnzacattack"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(files("libs/RRDiscordBridge.jar"))
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(
            "Plugin-Class" to "io.github.dexrnzacattack.ExampleBridgeExtension",
            "Plugin-Id" to "examplebridgeextension",
            "Plugin-Version" to "1.0.0",
        )
    }
}