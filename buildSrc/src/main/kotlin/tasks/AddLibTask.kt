@file:OptIn(ExperimentalStdlibApi::class)

package tasks

import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

@Suppress("MaxLineLength")
/**
 * ```
 * ./gradlew addLib --"projectName"="libs-catalog" --"artifactGroup"="org.example" --"artifactName"="example-name" --"artifactVersionRef"="exampleName" --"artifactVersion"="1.0.1"
 * ```
 */
open class AddLibTask : DefaultTask() {

    lateinit var projectName: String
        @Input get
        @Option(option = "projectName", description = "Project name") set

    lateinit var artifactGroup: String
        @Input get
        @Option(option = "artifactGroup", description = "Artifact group") set

    lateinit var artifactName: String
        @Input get
        @Option(option = "artifactName", description = "Artifact name") set

    lateinit var artifactVersionRef: String
        @Input get
        @Option(option = "artifactVersionRef", description = "Artifact version ref") set

    lateinit var artifactVersion: String
        @Input get
        @Option(option = "artifactVersion", description = "Artifact version") set

    private val artifactGroupClean: String
        get() =
            artifactGroup.replace(" ", "").also {
                check(regex.containsMatchIn(it)) { "Wrong artifact group" }
            }

    private val artifactNameClean: String
        get() =
            artifactName.replace(" ", "").also {
                check(regex.containsMatchIn(it)) { "Wrong artifact name" }
            }
    private val artifactVersionRefClean: String
        get() =
            artifactVersionRef.replace(" ", "").also {
                check(regex.containsMatchIn(it)) { "Wrong artifact version ref" }
            }

    private val artifactVersionClean: String
        get() =
            artifactVersion.replace(" ", "").also {
                check(regex.containsMatchIn(it)) { "Wrong artifact version" }
            }

    private val regex
        get() = Regex("""[a-zA-Z_0-9]""")

    @TaskAction
    fun create() {
        writeLibToChangelog()
        writeCatalog()
    }

    private fun writeLibToChangelog() {
        val addedRegex = Regex("""^(###)(\s)(Added)(.*)${'$'}""")

        File("${project.rootProject.projectDir}/CHANGELOG.md").apply {
            val content = readLines()
            val contentUpdated =
                buildList {
                        addAll(content)
                        add(
                            content.indexOfFirst { addedRegex.matches(it) } + 1,
                            "- $artifactGroupClean:$artifactName"
                        )
                    }
                    .joinToString("\n")
            writeText(contentUpdated)
        }
    }

    private fun writeCatalog() {
        val buildGradleFile = File("$projectName/build.gradle.kts")
        val buildGradleContent = buildGradleFile.readLines()
        val catalogStartIndex = buildGradleContent.indexOfFirst { it.contains("// catalog start") }

        val contentUpdated =
            buildList {
                    addAll(buildGradleContent.subList(0, catalogStartIndex))
                    addAll(
                        buildCatalog(
                            artifactGroupClean,
                            artifactNameClean,
                            artifactVersionRefClean,
                            artifactVersionClean,
                        )
                    )
                }
                .joinToString("\n")

        buildGradleFile.writeText(contentUpdated)
    }

    private fun buildCatalog(
        artifactGroup: String,
        artifactName: String,
        artifactVersionRef: String,
        artifactVersion: String,
    ): List<String> {
        val content = File("$projectName/build.gradle.kts").readLines()
        val catalogStartIndex = content.indexOfFirst { it.contains("// catalog start") } + 1
        val catalogEndIndex = content.indexOfFirst { it.contains("// catalog end") } - 1

        val catalog = content.subList(catalogStartIndex, catalogEndIndex)
        val catalogVersionsIndex = catalog.indexOfFirst { it.contains("[versions]") }
        val catalogLibrariesIndex = catalog.indexOfFirst { it.contains("[libraries]") }

        val versions = catalog.subList(catalogVersionsIndex + 1, catalogLibrariesIndex - 1)
        val libraries = catalog.subList(catalogLibrariesIndex + 1, catalog.count())

        return buildList {
            add("// catalog start")
            add("")
            add("// [versions]")
            addAll(
                (versions + generateVersionVal(artifactVersionRef, artifactVersion))
                    .distinctBy { it.substringBefore("=") }
                    .sorted()
            )
            add("")
            add("// [libraries]")
            addAll(
                (libraries + generateArtifact(artifactGroup, artifactName, artifactVersionRef))
                    .distinct()
                    .sorted()
            )
            add("")
            add("// catalog end")
            add("")
        }
    }

    private fun generateVersionVal(artifactVersionRef: String, artifactVersion: String): String =
        """val $artifactVersionRef = "$artifactVersion""""

    private fun generateArtifact(
        artifactGroup: String,
        artifactName: String,
        artifactVersionRef: String,
    ): String = """"$artifactGroup:$artifactName:$$artifactVersionRef""""
}
