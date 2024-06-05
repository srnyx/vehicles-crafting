import xyz.srnyx.gradlegalaxy.utility.setupAnnoyingAPI
import xyz.srnyx.gradlegalaxy.utility.spigotAPI


plugins {
    java
    id("xyz.srnyx.gradle-galaxy") version "1.1.3"
    id("io.github.goooler.shadow") version "8.1.7"
}

setupAnnoyingAPI("274e18ac01", "xyz.srnyx", "0.0.1", "Adds a customizable way to craft vehicles for the Vehicles Spigot plugin")
spigotAPI("1.15")

dependencies.compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))) // Vehicles
