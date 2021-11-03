plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    libs.apply {
        implementation(jsoup.jsoup)
        implementation(javiersc.kamp.scanner)
        implementation(javiersc.semanticVersioning.semanticVersioningCore)
    }

    pluginLibs.apply {
        implementation(javiersc.gradlePlugins.allPluginsX)

        implementation(jetbrains.kotlin.kotlinGradlePluginX)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
