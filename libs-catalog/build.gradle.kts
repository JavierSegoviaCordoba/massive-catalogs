plugins {
    `version-catalog`
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(files("../gradle/libs.versions.toml"))
    }
}
