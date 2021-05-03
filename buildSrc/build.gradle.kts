plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
    gradlePluginPortal()
    maven {
        setUrl("https://oss.sonatype.org/content/repositories/snapshots")
        content {
            includeGroup("com.javiersc.massive-catalogs")
            includeGroup("com.javiersc.gradle-plugins")
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    pluginLibs.apply {
        implementation(javiersc.gradlePlugins.changelog)
        implementation(javiersc.gradlePlugins.codeAnalysis)
        implementation(javiersc.gradlePlugins.codeFormatter)
        implementation(javiersc.gradlePlugins.dependencyUpdates)
        implementation(javiersc.gradlePlugins.docs)
        implementation(javiersc.gradlePlugins.kotlinMultiplatform)
        implementation(javiersc.gradlePlugins.kotlinMultiplatform)
        implementation(javiersc.gradlePlugins.publishKotlinJvm)
        implementation(javiersc.gradlePlugins.publishVersionCatalog)
        implementation(javiersc.gradlePlugins.nexus)
        implementation(javiersc.gradlePlugins.readmeBadgesGenerator)
        implementation(javiersc.gradlePlugins.versioning)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
