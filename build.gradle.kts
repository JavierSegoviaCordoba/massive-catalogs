plugins {
    versioning
    changelog
    `code-analysis`
    `dependency-updates`
    docs
    `binary-compatibility-validator`
    nexus
    readme
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }
}

val kotlinVersion = "1.4.20"

"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
