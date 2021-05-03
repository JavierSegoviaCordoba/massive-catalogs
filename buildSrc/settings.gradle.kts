import java.io.FileInputStream
import java.util.Properties

enableFeaturePreview("VERSION_CATALOGS")

val input = FileInputStream(file("../gradle.properties"))
val properties = Properties().apply { load(input) }

input.close()

val javierscGradlePlugins: String = properties.getProperty("javierscGradlePlugins")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("libs") { from(files("../libs-catalog/build/catalogs/libs.versions.toml")) }
        create("pluginLibs") {
            from(files("../plugins-catalog/build/catalogs/libs.versions.toml"))
            version("javierscGradlePlugins", javierscGradlePlugins)
        }
    }
}
