import xyz.srnyx.gradlegalaxy.utility.setupAnnoyingAPI
import xyz.srnyx.gradlegalaxy.utility.spigotAPI


plugins {
    java
    id("xyz.srnyx.gradle-galaxy") version "1.2.2"
    id("io.github.goooler.shadow") version "8.1.8"
}

spigotAPI("1.15")
setupAnnoyingAPI("5.0.0", "xyz.srnyx", "1.0.1", "Adds a customizable way to craft vehicles for the Vehicles Spigot plugin")

dependencies.compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))) // Vehicles
