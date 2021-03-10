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

// 
// val kotlin = "1.4.21"

// "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
