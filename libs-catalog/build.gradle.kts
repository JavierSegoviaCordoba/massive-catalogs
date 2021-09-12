@file:kotlin.Suppress("UNUSED_EXPRESSION")

plugins {
    `javiersc-publish-version-catalog`
}

catalog {
    versionCatalog {
        from(files("../gradle/libs.versions.toml"))
    }
}
