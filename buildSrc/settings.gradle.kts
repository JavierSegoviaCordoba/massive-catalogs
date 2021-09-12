enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories { mavenCentral() }

    versionCatalogs {
        create("libs") { from(files("../gradle/libs.versions.toml")) }
        create("pluginLibs") { from(files("../gradle/pluginLibs.versions.toml")) }
    }
}
