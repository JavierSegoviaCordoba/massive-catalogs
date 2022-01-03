plugins {
    `version-catalog`
    dokka
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(
            files("$buildDir/generated-catalog/libs.versions.toml"),
        )
    }
}
