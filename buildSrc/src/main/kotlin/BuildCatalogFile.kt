@file:OptIn(ExperimentalStdlibApi::class)

import java.io.File

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
        get() = group.split(".").takeLastWhile { !it.contains(domain) }.joinToString("-")

    private fun buildAlias(): String =
        "$domain-${("$groupAfterDomain-$name").replace("\"", "").replace(".", "-").replace(":", "-")}"
            .split("-")
            .filter { it.isNotBlank() }
            .map { it.replace("-", "") }
            .removeConsecutiveDuplicates()
            .joinToString("-")

    private fun buildArtifact(): String =
        if (version.isBlank()) """{ group = "$group", name = "$name" }"""
        else """{ group = "$group", name = "$name", version.ref = "$version" }"""

    private fun List<String>.removeConsecutiveDuplicates(): List<String> = buildList {
        for (word in this@removeConsecutiveDuplicates) {
            if (count() == 0 || last() != word) add(word)
        }
    }

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
