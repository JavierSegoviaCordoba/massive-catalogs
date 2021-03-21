import com.javiersc.plugins.core.groupId

plugins {
    kotlin("jvm")
    `javiersc-publish-kotlin-jvm`
}

group = groupId

dependencies {
    implementation(gradleApi())
}
