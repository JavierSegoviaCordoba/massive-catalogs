@file:OptIn(ExperimentalStdlibApi::class)

plugins {
    versioning
    changelog
    `code-analysis`
    `dependency-updates`
    docs
    `binary-compatibility-validator`
    nexus
    readme
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }

    register<tasks.AddLibTask>("addLib")
}

subprojects.onEach { subproject ->
    val content = buildCatalogFile(file("${subproject.projectDir}/build.gradle.kts"))

    if (content != null) {
        file("${subproject.buildDir}/catalogs/").apply {
            if (!exists()) mkdirs()
        }
        file("${subproject.buildDir}/catalogs/libs.versions.toml").apply {
            if (!exists()) createNewFile()
            writeText(content)
        }
    }
}
