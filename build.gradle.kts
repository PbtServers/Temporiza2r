import dev.s7a.gradle.minecraft.server.tasks.LaunchMinecraftServerTask
import kr.entree.spigradle.kotlin.*

plugins {
    java
    id("dev.s7a.gradle.minecraft.server") version "1.2.0"
    id("kr.entree.spigradle") version "2.4.3"
}

task<LaunchMinecraftServerTask>("ArrancarPaperTestServer") {
    dependsOn("build") // build task (build, jar, shadowJar, ...)
    doFirst {
        copy {
            from(buildDir.resolve("libs/Temporiza2r-1.0.jar")) // build/libs/example.jar
            into(buildDir.resolve("MinecraftPaperServer/plugins")) // build/MinecraftPaperServer/plugins
        }
    }

    jarUrl.set("https://papermc.io/api/v2/projects/paper/versions/1.16.5/builds/794/downloads/paper-1.16.5-794.jar")
    jarName.set("paper-1.16.5-794.jar")
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
    compileOnly(spigot("1.16.5"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

fun <T> ListProperty<T>.set(element: Array<T>) {
    set(element.toList())
}
