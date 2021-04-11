import com.javiersc.plugins.core.groupId
import com.javiersc.plugins.core.isSignificant

plugins {
    `javiersc-publish-version-catalog`
}

group = groupId

catalog {
    versionCatalog {
        from(files("$buildDir/catalogs/libs.versions.toml"))
    }
}

if (isSignificant) {
    file("$projectDir/build.gradle.kts").apply {
        writeText(
            readLines().joinToString("\n") {
                if (it.startsWith("val massiveCatalogs =")) "val massiveCatalogs = \"$version\"" else it
            } + "\n"
        )
    }
}

// catalog start

// [versions]
val android = "4.1.2"
val autoInclude = "1.3"
val changelog = "1.1.2"
val detekt = "1.16.0"
val dokka = "1.4.30"
val gradlePublish = "0.13.0"
val javierscGradlePlugins = "0.1.0-alpha.14"
val kotlin = "1.4.31"
val kotlinBinaryValidator = "0.5.0"
val ktfmt = "0.24"
val massiveCatalogs = "0.1.0-alpha.16"
val nexusPublish = "1.0.0"
val reckon = "0.13.0"
val spotless = "5.12.0"
val versions = "0.38.0"

// [libraries]
"com.android.tools.build:gradle:$android"
"com.diffplug.spotless:spotless-plugin-gradle:$spotless"
"com.facebook:ktfmt:$ktfmt"
"com.github.ben-manes:gradle-versions-plugin:$versions"
"com.gradle.publish:plugin-publish-plugin:$gradlePublish"
"com.javiersc.gradle-plugins:changelog:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:code-analysis:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:code-formatter:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:dependency-updates:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:docs:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:kotlin-multiplatform:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:nexus:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-android-library:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-gradle-plugin:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-kotlin-jvm:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-kotlin-multiplatform:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-version-catalog:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:readme-badges-generator:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:versioning:$javierscGradlePlugins"
"com.javiersc.massive-catalogs:plugins-accessors:$massiveCatalogs"
"com.pablisco.gradle.auto.include:plugin:$versions"
"io.github.gradle-nexus:publish-plugin:$nexusPublish"
"io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detekt"
"org.ajoberstar.reckon:reckon-gradle:$reckon"
"org.jetbrains.dokka:dokka-core:$dokka"
"org.jetbrains.dokka:dokka-gradle-plugin:$dokka"
"org.jetbrains.intellij.plugins:gradle-changelog-plugin:$changelog"
"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"
"org.jetbrains.kotlin:kotlin-serialization:$kotlin"
"org.jetbrains.kotlinx:binary-compatibility-validator:$kotlinBinaryValidator"

// catalog end
