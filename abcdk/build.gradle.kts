plugins {
    `maven-publish`
    kotlin("jvm") version "1.4.32"
    id("pl.mareklangiewicz.deps")
}

group = "com.github.langara.abcdk"
version = "0.0.3"

dependencies {
    implementation(Deps.kotlinStdlib8)
    testImplementation(Deps.junit5)
    testImplementation(Deps.junit5engine)
    testImplementation(Deps.uspek)
}

tasks.test {
    useJUnitPlatform()
}

// Create sources Jar from main kotlin sources
val sourcesJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles sources JAR"
    classifier = "sources"
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create("default", MavenPublication::class.java) {
            from(components.getByName("java"))
            artifact(sourcesJar)
        }
    }
    repositories {
        maven {
            url = uri("$buildDir/repository")
        }
    }
}
