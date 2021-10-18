import scanner.ScannerTask
import tasks.AddLibTask

plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-docs`
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }

    register<AddLibTask>("addLib")
    register<ScannerTask>("mavenScan")
}
