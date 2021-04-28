@file:Suppress(
    "FunctionName",
    "TopLevelPropertyNaming",
    "ObjectPropertyName",
    "RemoveRedundantBackticks",
    "TooManyFunctions"
)

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.`android-library`: PluginDependencySpec
    get() = id("com.android.library")

fun PluginDependenciesSpec.`android-library`(version: String): PluginDependencySpec =
    id("com.android.library").version(version)

val PluginDependenciesSpec.`android-application`: PluginDependencySpec
    get() = id("com.android.application")

fun PluginDependenciesSpec.`android-application`(version: String): PluginDependencySpec =
    id("com.android.application").version(version)

val PluginDependenciesSpec.`auto-include`: PluginDependencySpec
    get() = id("com.pablisco.gradle.auto.include")

fun PluginDependenciesSpec.`auto-include`(version: String): PluginDependencySpec =
    id("com.pablisco.gradle.auto.include").version(version)

val PluginDependenciesSpec.`ben-manes-versions`: PluginDependencySpec
    get() = id("com.github.ben-manes.versions")

fun PluginDependenciesSpec.`ben-manes-versions`(version: String): PluginDependencySpec =
    id("com.github.ben-manes.versions").version(version)

val PluginDependenciesSpec.`changelog`: PluginDependencySpec
    get() = id("org.jetbrains.changelog")

fun PluginDependenciesSpec.`changelog`(version: String): PluginDependencySpec =
    id("org.jetbrains.changelog").version(version)

val PluginDependenciesSpec.`hilt-android`: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.`hilt-android`(version: String): PluginDependencySpec =
    id("dagger.hilt.android.plugin").version(version)

val PluginDependenciesSpec.`detekt`: PluginDependencySpec
    get() = id("io.gitlab.arturbosch.detekt")

fun PluginDependenciesSpec.`detekt`(version: String): PluginDependencySpec =
    id("io.gitlab.arturbosch.detekt").version(version)

val PluginDependenciesSpec.`dokka`: PluginDependencySpec
    get() = id("org.jetbrains.dokka")

fun PluginDependenciesSpec.`dokka`(version: String): PluginDependencySpec =
    id("org.jetbrains.dokka").version(version)

val PluginDependenciesSpec.`gradle-plugin-publish`: PluginDependencySpec
    get() = id("com.gradle.plugin-publish")

fun PluginDependenciesSpec.`gradle-plugin-publish`(version: String): PluginDependencySpec =
        id("com.gradle.plugin-publish").version(version)

val PluginDependenciesSpec.`kotlin-android`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.android")

fun PluginDependenciesSpec.`kotlin-android`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.android").version(version)

val PluginDependenciesSpec.`kotlin-jvm`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.jvm")

fun PluginDependenciesSpec.`kotlin-jvm`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.jvm").version(version)

val PluginDependenciesSpec.`kotlin-js`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.js")

fun PluginDependenciesSpec.`kotlin-js`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.js").version(version)

val PluginDependenciesSpec.`kotlin-kapt`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.kapt")

fun PluginDependenciesSpec.`kotlin-kapt`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.kapt").version(version)

val PluginDependenciesSpec.`kotlin-multiplatform`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.multiplatform")

fun PluginDependenciesSpec.`kotlin-multiplatform`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.multiplatform").version(version)

val PluginDependenciesSpec.`kotlin-parcelize`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.plugin.parcelize")

fun PluginDependenciesSpec.`kotlin-parcelize`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.plugin.parcelize").version(version)

val PluginDependenciesSpec.`kotlin-serialization`: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.plugin.serialization")

fun PluginDependenciesSpec.`kotlin-serialization`(version: String): PluginDependencySpec =
    id("org.jetbrains.kotlin.plugin.serialization").version(version)

val PluginDependenciesSpec.`kotlinx-binary-compatibility-validator`: PluginDependencySpec
    get() = id("org.jetbrains.kotlinx.binary-compatibility-validator")

fun PluginDependenciesSpec.`kotlin-binary-compatibility-validator`(
    version: String
): PluginDependencySpec =
    id("org.jetbrains.kotlinx.binary-compatibility-validator").version(version)

val PluginDependenciesSpec.`mkdocs`: PluginDependencySpec
    get() = id("ru.vyarus.mkdocs")

fun PluginDependenciesSpec.`mkdocs`(version: String): PluginDependencySpec =
    id("ru.vyarus.mkdocs").version(version)

val PluginDependenciesSpec.`nexus-publish`: PluginDependencySpec
    get() = id("io.github.gradle-nexus.publish-plugin")

fun PluginDependenciesSpec.`nexus-publish`(version: String): PluginDependencySpec =
    id("io.github.gradle-nexus.publish-plugin").version(version)

val PluginDependenciesSpec.`reckon`: PluginDependencySpec
    get() = id("org.ajoberstar.reckon")

fun PluginDependenciesSpec.`reckon`(version: String): PluginDependencySpec =
    id("org.ajoberstar.reckon").version(version)

val PluginDependenciesSpec.`spotless`: PluginDependencySpec
    get() = id("com.diffplug.spotless")

fun PluginDependenciesSpec.`spotless`(version: String): PluginDependencySpec =
    id("com.diffplug.spotless").version(version)
