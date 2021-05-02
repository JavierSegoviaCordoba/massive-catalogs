# Module kotlin-catalog

Version Catalog which has a bundle of all Kotlin libraries in MavenCentral. Powered by 
[`KAMP`](https://github.com/mpetuska/kamp) scanner.

### Download from MavenCentral

```kotlin
// settings.gradle.kts

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("kotlinLibs") { from("com.javiersc.massive-catalogs:libs-catalog:$version") }
    }
}
```

### Usage

Projects accessors are generated automatically.

```kotlin
dependencies {
    implementation(kotlinLibs.jetbrains.kotlinx.kotlinxCoroutinesCore)
}
```

### Codegen sample

The codegen for Kotlin Coroutines core artifact:

`org.jetbrains.kotlinx:kotlinx-coroutines-core` -> `libs.jetbrains.kotlinx.kotlinxCoroutinesCore`
