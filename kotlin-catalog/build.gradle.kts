
plugins {
    `javiersc-publish-version-catalog`
}

catalog {
    versionCatalog {
        from(
            files(
                file("${rootProject.buildDir}/catalogs").walkTopDown().filter {
                    it.isFile && it.extension == "toml"
                }.toList()
            )
        )
    }
}
