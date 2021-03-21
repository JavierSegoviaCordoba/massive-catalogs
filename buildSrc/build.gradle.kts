plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    jcenter()
    google()
    gradlePluginPortal()
}

dependencies {
    /**
     * ToDo: workaround until accessors are available (https://github.com/gradle/gradle/issues/15383)
     *  When it is fixed, remove both implementations and remove `VersionCatalogExtension.kt` file
     */
    implementation(files(pluginLibs.javaClass.protectionDomain.codeSource.location))

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
        implementation(javiersc.massiveCatalogs.pluginsAccessors)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
