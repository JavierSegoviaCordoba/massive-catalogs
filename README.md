![Kotlin version](https://img.shields.io/badge/kotlin-1.4.31-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.massive-catalogs/libs-catalog?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/massive-catalogs/libs-catalog/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.massive-catalogs/libs-catalog?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/massive-catalogs/libs-catalog/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/massive-catalogs/build?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/massive-catalogs/tree/main)
[![Quality](https://img.shields.io/sonar/quality_gate/JavierSegoviaCordoba_massive-catalogs?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_massive-catalogs)
[![Tech debt](https://img.shields.io/sonar/tech_debt/JavierSegoviaCordoba_massive-catalogs?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_massive-catalogs)

# RunBlocking KMP

```kotlin
fun main() = runBlocking {
    println(usersService.getUsers())
}
```

### Docs

All docs are available on the [RunBlocking KMP website](https://run-blocking-kmp.javiersc.com)

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking:$version")
```
