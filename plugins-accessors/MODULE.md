# Module plugins-accessors

Set of accessors for Gradle plugins

### Download from MavenCentral

```kotlin
// buildSrc/build.gradle.kts

dependencies {
    implementation("com.javiersc.massive-catalogs:plugins-accessors:$version")
}
```

### Usage

Each plugin can be applied with or without version, depending on how the plugin dependency is added,
for example:

```kotlin
plugins {
    `android-library`
}
```

```kotlin
plugins {
    `android-library` version "4.1.3"
}
```
### List of plugins

- `android-library`
- `android-application`
- `auto-include`
- `ben-manes-versions`
- `changelog`
- `hilt-android`
- `detekt`
- `dokka`
- `gradle-plugin-publish`
- `kotlin-android`
- `kotlin-jvm`
- `kotlin-js`
- `kotlin-kapt`
- `kotlin-multiplatform`
- `kotlin-parcelize`
- `kotlin-serialization`
- `kotlinx-binary-compatibility-validator`
- `mkdocs`
- `nexus-publish`
- `reckon`
- `spotless`
