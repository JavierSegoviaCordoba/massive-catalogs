package tasks

import com.javiersc.plugins.core.isSignificant
import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class UpdateMassiveCatalogsTask : DefaultTask() {

    @TaskAction
    fun create() {
        if (project.rootProject.isSignificant) {
            File("${project.rootProject.rootDir}/gradle.properties").apply {
                writeText(
                    readLines().joinToString("\n") { line ->
                        if (line.startsWith("massiveCatalogs=")) {
                            "massiveCatalogs=${project.rootProject.version}"
                        } else {
                            line
                        }
                    } + "\n"
                )
            }
        }
    }
}
