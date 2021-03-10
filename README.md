![Kotlin version](https://img.shields.io/badge/kotlin-1.4.31-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.massive-catalogs/libs-catalog?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/massive-catalogs/libs-catalog/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.massive-catalogs/libs-catalog?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/massive-catalogs/libs-catalog/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/massive-catalogs/build?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/massive-catalogs/tree/main)
[![Quality](https://img.shields.io/sonar/quality_gate/JavierSegoviaCordoba_massive-catalogs?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_massive-catalogs)
[![Tech debt](https://img.shields.io/sonar/tech_debt/JavierSegoviaCordoba_massive-catalogs?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_massive-catalogs)

# Massive Catalogs

```kotlin
// build.gradle.kts
dependencies {
    implementation(libs.squareup.retrofit2.retrofit)
}
```

### Docs

All docs are available on the [Massive Catalog website](https://massive-catalogs.javiersc.com)

### Download from MavenCentral

In the `settings.gradle.kts` file

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from("com.javiersc.massive-catalogs:libs-catalog:$version")
        }

        create("pluginsLibs") {
            from("com.javiersc.massive-catalogs:plugins-catalog:$version")
        }
    }
}
```
