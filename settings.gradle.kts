
rootProject.name = providers.gradleProperty("libName").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }
}

include(":libs-catalog")
include(":plugins-catalog")
