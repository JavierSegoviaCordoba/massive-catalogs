import java.io.FileInputStream
import java.util.Properties

val input = FileInputStream(file("../gradle.properties"))
val properties = Properties().apply { load(input) }

input.close()

val massiveCatalogs: String = properties.getProperty("massiveCatalogs")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") { from("com.javiersc.massive-catalogs:libs-catalog:$massiveCatalogs") }
        create("pluginLibs") {
            from("com.javiersc.massive-catalogs:plugins-catalog:$massiveCatalogs")
        }
    }
}
