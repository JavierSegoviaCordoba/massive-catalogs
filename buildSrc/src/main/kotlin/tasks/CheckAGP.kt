@file:Suppress("MagicNumber")

package tasks

import java.net.HttpURLConnection
import java.net.URL
import kotlin.streams.toList
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class CheckAGP : DefaultTask() {
    init {
        description = "Check last Android Gradle Plugin version compatible with IntelliJ IDEA"
        group = "help"
    }

    private val url =
        "https://raw.githubusercontent.com/JetBrains" +
            "/android/master/adt-branding/src/idea/AndroidStudioApplicationInfo.xml"

    @TaskAction
    fun create() {
        (URL(url).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            if (responseCode !in 200..299) error("There is an error checking AGP")

            inputStream.bufferedReader().use {
                val original =
                    it.lines().toList().first { line -> line.contains("<version major=") }

                val versionCode =
                    original
                        .filter { char -> char.isDigit() || char == '"' }
                        .replace("\"\"", "\"")
                        .replace("\"", ".")
                        .dropWhile { char -> char.isDigit().not() }
                        .dropLastWhile { char -> char.isDigit().not() }
                        .dropLastWhile { char -> char.isDigit() }
                        .dropLastWhile { char -> char.isDigit().not() }

                val versionName =
                    if (original.contains("RC", ignoreCase = true) ||
                            original.contains("Beta", ignoreCase = true) ||
                            original.contains("Canary", ignoreCase = true)
                    ) {
                        original
                            .replaceBefore("{", "")
                            .replaceAfterLast("eap", "")
                            .dropLastWhile { char -> char.isLetter().not() }
                            .replace("{", "")
                            .replace("}", "")
                            .replace(".", "")
                            .replace("\"", "")
                            .replace("eap", "")
                            .dropWhile { char -> char.isDigit() }
                            .dropWhile { char -> char.isWhitespace() }
                    } else null

                val version =
                    if (versionName != null) "$versionCode - $versionName" else versionCode

                val reset = "\u001B[0m"
                val yellow = "\u001B[33m"
                val green = "\u001B[32m"

                logger.lifecycle(
                    "${green}Latest Android Gradle Plugin version" +
                        " compatible with IntelliJ IDEA: $yellow$version$reset"
                )
            }
        }
    }
}
