plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev")
    id("xyz.jpenilla.run-paper")
}

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.21.8-R0.1-SNAPSHOT")
    compileOnly("de.miraculixx:kpaper:1.2.1")
    implementation("dev.jorel:commandapi-bukkit-shade-mojang-mapped:10.1.2")
    implementation("dev.jorel:commandapi-bukkit-kotlin:10.1.2")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    
    reobfJar {
        // Настройка имени JAR файла в формате проект-версия-коммит
        val projectName = project.name
        val version = project.version.toString()
        val commitHash = providers.exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
        }.standardOutput.asText.get().trim()
        
        outputJar.set(layout.buildDirectory.file("libs/$projectName-$version-$commitHash-reobf.jar"))
    }
    
    jar {
        // Настройка имени обычного JAR файла
        val projectName = project.name
        val version = project.version.toString()
        val commitHash = providers.exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
        }.standardOutput.asText.get().trim()
        
        archiveBaseName.set("$projectName-$version-$commitHash")
        archiveVersion.set("")
    }
}
