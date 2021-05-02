# Module plugins-catalog

Version Catalog which has a bundle of Gradle plugins selected manually.

### Download from MavenCentral

```kotlin
// settings.gradle.kts

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("pluginLibs") { from("com.javiersc.massive-catalogs:plugins-catalog:$version") }
    }
}
```

### Usage

Projects accessors are generated automatically.

```kotlin
dependencies {
    implementation(pluginLibs.jetbrains.kotlin.kotlinGradlePlugin)
}
```

### Codegen sample

The codegen for Kotlin Gradle plugin artifact:

`org.jetbrains.kotlin:kotlin-gradle-plugin` -> `libs.jetbrains.kotlin.kotlinGradlePlugin`
