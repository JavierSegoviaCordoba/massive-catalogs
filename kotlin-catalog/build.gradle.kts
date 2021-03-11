import internal.groupId

plugins { publish }

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
