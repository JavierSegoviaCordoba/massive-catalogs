import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated
import scanner.ScannerTask
import tasks.AddLibTask

plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-docs`
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }

    register<AddLibTask>("addLib")

    val mavenScan = register<ScannerTask>("mavenScan") {
        finalizedBy("generateKotlinCatalog")
    }

    register("generateKotlinCatalog") {
        mustRunAfter(mavenScan)

        doLast {
            fun String.dotOrDashToCamelCase(): String =
                replace("-", ".")
                    .fold("") { a, b -> a + if (a.lastOrNull() == '.') b.toUpperCase() else b }
                    .replace(".", "")

            val libsTXTs: List<File> =
                file("$buildDir/catalogs/").listFiles()?.toList().orEmpty().filter { file ->
                    file.isFile && file.extension == "txt"
                }
            val libs: List<String> = libsTXTs.flatMap { file -> file.readLines() }
            val tomlLibs =
                @OptIn(ExperimentalStdlibApi::class)
                buildList {
                    add("[libraries]")
                    for (lib in libs) {
                        val first = lib.substringBefore(".")
                        val second =
                            lib.substringAfter(".").substringBefore(":").replace(".", "-")
                        val third =
                            lib.substringAfter(":")
                                .substringBeforeLast(":")
                                .dotOrDashToCamelCase()
                        val alias = "$first-$second-$third"

                        add("""$alias = "$lib"""")
                    }
                }
                    .joinToString("\n")

            file("$rootDir/kotlin-catalog/build/generated-catalog/libs.versions.toml").apply {
                ensureParentDirsCreated()
                createNewFile()

                writeText(tomlLibs)
            }
        }
    }
}
