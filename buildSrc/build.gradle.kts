plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    libs.apply { implementation(javiersc.kamp.scanner) }

    pluginLibs.apply {
        implementation(javiersc.gradlePlugins.allProjects)
        implementation(javiersc.gradlePlugins.changelog)
        implementation(javiersc.gradlePlugins.codeAnalysis)
        implementation(javiersc.gradlePlugins.codeFormatter)
        implementation(javiersc.gradlePlugins.dependencyUpdates)
        implementation(javiersc.gradlePlugins.docs)
        implementation(javiersc.gradlePlugins.kotlinMultiplatform)
        implementation(javiersc.gradlePlugins.publishKotlinJvm)
        implementation(javiersc.gradlePlugins.publishVersionCatalog)
        implementation(javiersc.gradlePlugins.nexus)
        implementation(javiersc.gradlePlugins.readmeBadges)
        implementation(javiersc.gradlePlugins.versioning)

        implementation(jetbrains.kotlin.kotlinGradlePlugin)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
