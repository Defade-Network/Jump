plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.defade"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.defade.net/defade") {
        name = "DefadeRepository"
        credentials(PasswordCredentials::class)
    }
}

dependencies {
    implementation("net.defade:minestom:1.21-769865102b")
    implementation("net.kyori:adventure-text-minimessage:4.17.0")
}

// Set compile version to 21
tasks.withType<JavaCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "net.defade.jump.Main")
    }
}