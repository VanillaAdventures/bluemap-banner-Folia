plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
}


tasks {
    shadowJar {
        dependencies {
            include {
                it.moduleGroup == properties["group"] as String || it.moduleGroup == "dev.jorel" || it.moduleGroup == "com.tcoded"
            }
        }
        relocate("dev.jorel.commandapi", "de.miraculixx.bmbm.commandapi")
        relocate("com.tcoded.folialib", "de.miraculixx.bmbm.lib.folialib")
    }
}