# Module libs-catalog

Version Catalog which has a bundle of libraries selected manually.

### Download from MavenCentral

```kotlin
// settings.gradle.kts

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("libs") { from("com.javiersc.massive-catalogs:libs-catalog:$version") }
    }
}
```

### Usage

Projects accessors are generated automatically.

```kotlin
dependencies {
    implementation(libs.org.jetbrains.kotlinx.kotlinxCoroutinesCore)
}
```

### Codegen sample

The codegen for Kotlin Coroutines core artifact:

`org.jetbrains.kotlinx:kotlinx-coroutines-core`
-> `libs.org.jetbrains.kotlinx.kotlinxCoroutinesCore`
