plugins {
    `version-catalog`
    dokka
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(files("../gradle/pluginLibs.versions.toml"))
    }
}
