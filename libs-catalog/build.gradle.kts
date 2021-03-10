import internal.groupId

plugins {
    `version-catalog`
    publish
}

group = groupId

catalog {
    versionCatalog {
        from(files("$projectDir/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}

// [versions]
val kotlin = "1.4.31"

// [libraries]
"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"
implementation(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = kotlin)

fun implementation(group: String, name: String, version: String) = println("$group:$name:$version")
