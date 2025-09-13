
plugins {
    `kotlin-script`
    `paper-script`
    `shadow-script`
}

repositories {
    maven {
        name = "tcoded-releases"
        url = uri("https://repo.tcoded.com/releases")
    }
}

dependencies {
//    implementation(project(":vanilla"))
    implementation("com.tcoded:FoliaLib:0.5.1")
}

sourceSets {
    main {
        resources.srcDirs("$rootDir/commons/")
    }
}

group = "de.miraculixx.bmbm"
setProperty("module_name", "bmbm")