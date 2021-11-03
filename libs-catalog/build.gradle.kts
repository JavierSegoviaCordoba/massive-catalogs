plugins {
    `version-catalog`
    dokka
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(files("../gradle/libs.versions.toml"))
    }
}
