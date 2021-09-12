plugins {
    `javiersc-publish-version-catalog`
}

catalog {
    versionCatalog {
        from(files("../gradle/pluginLibs.versions.toml"))
    }
}
