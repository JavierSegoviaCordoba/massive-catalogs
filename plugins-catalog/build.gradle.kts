plugins {
    `version-catalog`
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(files("../gradle/pluginLibs.versions.toml"))
    }
}
