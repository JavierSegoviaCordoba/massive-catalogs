dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
            content { includeGroup("com.javiersc.massive-catalogs") }
        }
    }

    versionCatalogs {

        create("testingLibs") { from("com.javiersc.massive-catalogs:libs-catalog:0.2.0-SNAPSHOT") }

        create("testingKotlinLibs") {
            from("com.javiersc.massive-catalogs:kotlin-catalog:0.2.0-SNAPSHOT")
        }

        create("testingPlugins") {
            from("com.javiersc.massive-catalogs:plugins-catalog:0.2.0-SNAPSHOT")
        }
    }
}
