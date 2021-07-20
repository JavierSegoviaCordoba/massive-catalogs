plugins {
    `javiersc-publish-version-catalog`
}

catalog {
    versionCatalog {
        from(files("$buildDir/catalogs/libs.versions.toml"))
    }
}

// catalog start

// [versions]
val android = "4.1.3"
val autoInclude = "1.3"
val changelog = "1.1.2"
val dagger = "2.38"
val detekt = "1.17.1"
val dokka = "1.5.0"
val gradlePublish = "0.13.0"
val javierscGradlePlugins = "0.1.0-alpha.40"
val kotlin = "1.5.21"
val kotlinBinaryValidator = "0.6.0"
val kotlinPowerAssert = "0.10.0"
val ksp = "1.5.21-1.0.0-beta05"
val mkdocs = "2.1.1"
val nexusPublish = "1.1.0"
val reckon = "0.13.0"
val spotless = "5.14.1"
val versions = "0.39.0"

// [libraries]
"com.android.tools.build:gradle:$android"
"com.diffplug.spotless:spotless-plugin-gradle:$spotless"
"com.github.ben-manes:gradle-versions-plugin:$versions"
"com.google.dagger:hilt-android-gradle-plugin:$dagger"
"com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:$ksp"
"com.gradle.publish:plugin-publish-plugin:$gradlePublish"
"com.javiersc.gradle-plugins:all-plugins:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:all-projects:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:changelog:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:code-analysis:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:code-formatter:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:dependency-updates:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:docs:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:gradle-wrapper-updater:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:kotlin-multiplatform:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:massive-catalogs-updater:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:nexus:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:plugin-accessors:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-android-library:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-gradle-plugin:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-kotlin-jvm:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-kotlin-multiplatform:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:publish-version-catalog:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:readme-badges:$javierscGradlePlugins"
"com.javiersc.gradle-plugins:versioning:$javierscGradlePlugins"
"com.pablisco.gradle.auto.include:plugin:$versions"
"gradle.plugin.com.bnorm.power:kotlin-power-assert-gradle:$kotlinPowerAssert"
"io.github.gradle-nexus:publish-plugin:$nexusPublish"
"io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detekt"
"org.ajoberstar.reckon:reckon-gradle:$reckon"
"org.jetbrains.dokka:dokka-core:$dokka"
"org.jetbrains.dokka:dokka-gradle-plugin:$dokka"
"org.jetbrains.intellij.plugins:gradle-changelog-plugin:$changelog"
"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"
"org.jetbrains.kotlin:kotlin-serialization:$kotlin"
"org.jetbrains.kotlinx:binary-compatibility-validator:$kotlinBinaryValidator"
"ru.vyarus:gradle-mkdocs-plugin:$mkdocs"

// catalog end
