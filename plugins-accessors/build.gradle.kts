import internal.groupId

plugins {
    kotlin("jvm")
    publish
}

group = groupId

publishing {
    publications {
        create<MavenPublication>("Accessors") {
            from(components["java"])
        }
    }
}

dependencies {
    implementation(gradleApi())
}

// catalog start

// [versions]
val android = "4.1.2"
val autoInclude = "1.3"
val changelog = "1.1.2"
val versions = "0.38.0"
val detekt = "1.16.0"
val dokka = "1.4.30"
val ktfmt = "0.21"
val kotlin = "1.4.31"
val kotlinBinaryValidator = "0.4.0"
val nexusPublish = "1.0.0"
val reckon = "0.13.0"
val spotless = "5.11.0"

// [libraries]
"org.ajoberstar.reckon:reckon-gradle:$reckon"
"com.android.tools.build:gradle:$android"
"com.diffplug.spotless:spotless-plugin-gradle:$spotless"
"com.github.ben-manes:gradle-versions-plugin:$versions"
"com.pablisco.gradle.auto.include:plugin:$versions"
"io.github.gradle-nexus:publish-plugin:$nexusPublish"
"io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detekt"
"org.jetbrains.dokka:dokka-core:$dokka"
"org.jetbrains.dokka:dokka-gradle-plugin:$dokka"
"org.jetbrains.intellij.plugins:gradle-changelog-plugin:$changelog"
"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin"
"org.jetbrains.kotlin:kotlin-serialization:$kotlin"
"org.jetbrains.kotlinx:binary-compatibility-validator:$kotlinBinaryValidator"

// catalog end
