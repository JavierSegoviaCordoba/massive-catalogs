@file:Suppress("UnstableApiUsage")

rootProject.name = providers.gradleProperty("allProjects.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

include(
    ":kotlin-catalog",
    ":libs-catalog",
    ":plugins-catalog",
)

// includeBuild("testing-catalog")

/** Build local catalogs */
listOf("libs-catalog", "plugins-catalog").onEach { path ->
    val content = buildCatalogFile(file("$path/build.gradle.kts"))

    if (content != null) {
        file("$path/build/catalogs/").mkdirs()
        file("$path/build/catalogs/libs.versions.toml").apply {
            if (!exists()) createNewFile()
            writeText(content)
        }
    }
}

fun buildCatalogFile(file: File): String? {
    val content = file.readLines()

    if (!content.contains("// catalog start")) return null

    val catalogStartIndex = content.indexOfFirst { it.contains("// catalog start") } + 1
    val catalogEndIndex = content.indexOfFirst { it.contains("// catalog end") } - 1

    return content.subList(catalogStartIndex, catalogEndIndex).joinToString("\n") {
        val line = it.replace("/", "")
        when {
            line.contains("[") -> line.replace(" ", "")
            line.isBlank() -> line
            line.startsWith("val ") -> VersionRef.build(line).buildAsString()
            line.contains(":") -> Artifact.build(line).buildAsString()
            else -> "// Line uncovered"
        }
    }
}

class VersionRef(private val ref: String, private val version: String) {

    fun buildAsString(): String = """$ref = "$version""""

    companion object {
        fun build(line: String): VersionRef =
            VersionRef(
                ref = line.replace("val ", "").split(" ")[0],
                version = line.replace(" ", "").replace("\"", "").split("=")[1]
            )
    }
}

class Artifact(private val group: String, private val name: String, private val version: String) {

    fun buildAsString(): String = "${buildAlias()} = ${buildArtifact()}"

    private val domain: String
        get() = group.split(".")[1]

    private val groupAfterDomain: String
        get() =
            group
                .split(".")
                .takeLastWhile { !it.contains(domain) }
                .joinToString("-")
                .cleanUnderscore()
                .cleanHyphen()

    private val cleanName: String
        get() = name.cleanHyphen().cleanUnderscore()

    private fun buildAlias(): String =
        "$domain-${
            ("$groupAfterDomain-$cleanName").replaceSeparators()
        }"
            .split("-")
            .filter { it.isNotBlank() }
            .joinToString("-") { it.replace("-", "") }
            .sanitizeAlias()

    private fun String.sanitizeAlias(): String {
        return if (endsWith("plugin", true) ||
            endsWith("plugins", true) ||
            endsWith("bundle", true) ||
            endsWith("bundles", true) ||
            endsWith("version", true) ||
            endsWith("versions", true)
        ) {
            this + "X"
        } else {
            this
        }
    }

    private fun buildArtifact(): String =
        if (version.isBlank()) """{ group = "$group", name = "$name" }"""
        else """{ group = "$group", name = "$name", version.ref = "$version" }"""

    private fun String.replaceSeparators(): String =
        replace("\"", "").replace(".", "-").replace(":", "-")

    private fun String.cleanHyphen(firstLowerCase: Boolean = true): String =
        this.split('-').toStringCamelCase(firstLowerCase)

    private fun String.cleanUnderscore(firstLowerCase: Boolean = true): String =
        this.split('_').toStringCamelCase(firstLowerCase)

    private fun List<String>.toStringCamelCase(firstLowerCase: Boolean = true): String =
        joinToString("", transform = String::capitalize)
            .mapIndexed { index: Int, char: Char ->
                if (index == 0 && firstLowerCase) char.toLowerCase() else char
            }
            .joinToString("")

    companion object {
        fun build(line: String): Artifact =
            line.replace("\"", "").replace("\$", "").split(":").run {
                Artifact(
                    group = get(0),
                    name = get(1),
                    version = getOrNull(2) ?: "",
                )
            }
    }
}
