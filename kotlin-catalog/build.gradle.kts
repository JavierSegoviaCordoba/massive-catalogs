import internal.groupId

plugins {
    `publish-catalog`
}

group = groupId

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
