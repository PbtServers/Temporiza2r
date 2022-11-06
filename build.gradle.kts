import dev.s7a.gradle.minecraft.server.tasks.LaunchMinecraftServerTask

plugins {
    java
    id("dev.s7a.gradle.minecraft.server") version "1.2.0"
}

task<LaunchMinecraftServerTask>("ArrancarPaperTestServer") {
    dependsOn("build") // build task (build, jar, shadowJar, ...)
    doFirst {
        copy {
            from(buildDir.resolve("libs/Plugin-1.0.jar")) // build/libs/example.jar
            into(buildDir.resolve("MinecraftPaperServer/plugins")) // build/MinecraftPaperServer/plugins
        }
    }

    jarUrl.set("https://papermc.io/api/v2/projects/paper/versions/1.18.2/builds/287/downloads/paper-1.18.2-287.jar")
    jarName.set("paper-1.18.2-287.jar")
    serverDirectory.set(buildDir.resolve("MinecraftPaperServer")) // build/MinecraftPaperServer
    nogui.set(true)

    val element = arrayOf("-Dfile.encoding=utf-8");
    jvmArgument.set(element);
    agreeEula.set(true)
}

group = "pbtservers"
version = "1.0"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

fun <T> ListProperty<T>.set(element: Array<T>) {
    set(element.toList())
}
