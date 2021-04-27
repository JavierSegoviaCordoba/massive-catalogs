import java.io.FileInputStream
import java.util.Properties

enableFeaturePreview("VERSION_CATALOGS")

val input = FileInputStream(file("../gradle.properties"))
val properties = Properties().apply { load(input) }

input.close()

val massiveCatalogs: String = properties.getProperty("massiveCatalogs")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        jcenter()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") { from("com.javiersc.massive-catalogs:libs-catalog:$massiveCatalogs") }
        create("pluginLibs") {
            from("com.javiersc.massive-catalogs:plugins-catalog:$massiveCatalogs")
            version("javierscGradlePlugins", "0.1.0-alpha.19")
        }
    }
}
