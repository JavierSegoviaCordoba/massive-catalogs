
rootProject.name = providers.gradleProperty("libName").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }
}

include(":libs-catalog")
include(":kotlin-catalog")
include(":plugins-accessors")
include(":plugins-catalog")

includeBuild("testing-catalog")
