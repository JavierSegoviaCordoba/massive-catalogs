rootProject.name = providers.gradleProperty("allProjects.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

val isKotlinProjectEnabled: Boolean =
    providers
        .gradleProperty("projects.kotlinCatalog.isEnabled")
        .forUseAtConfigurationTime()
        .orNull
        ?.toBoolean()
        ?: true

if (isKotlinProjectEnabled) include(":kotlin-catalog")

val allProjectsExceptKotlinCatalogEnabled: Boolean =
    providers
        .gradleProperty("projects.allExceptKotlinCatalog.areEnabled")
        .forUseAtConfigurationTime()
        .orNull
        ?.toBoolean()
        ?: true

if (allProjectsExceptKotlinCatalogEnabled) {
    include(
        ":libs-catalog",
        ":plugins-catalog",
    )
}
