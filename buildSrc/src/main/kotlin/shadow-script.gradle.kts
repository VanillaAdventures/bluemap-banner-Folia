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
        
        // Настройка имени JAR файла в формате проект-версия-коммит
        val projectName = project.name
        val version = project.version.toString()
        val commitHash = providers.exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
        }.standardOutput.asText.get().trim()
        
        archiveBaseName.set("$projectName-$version-$commitHash")
        archiveVersion.set("")
    }
}