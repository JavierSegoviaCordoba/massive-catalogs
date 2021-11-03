plugins {
    `version-catalog`
    dokka
    `javiersc-publish`
}

catalog {
    versionCatalog {
        from(
            files(
                file("${rootProject.buildDir}/catalogs").walkTopDown().filter {
                    it.isFile && it.extension == "toml"
                }.toList(),
            ),
        )
    }
}
