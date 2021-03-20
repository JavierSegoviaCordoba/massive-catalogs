
rootProject.name = providers.gradleProperty("libName").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        jcenter()
        gradlePluginPortal()
    }
}

include(":libs-catalog")
//include(":kotlin-catalog")
include(":plugins-accessors")
include(":plugins-catalog")

includeBuild("testing-catalog")
