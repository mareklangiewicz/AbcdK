plugins {
    kotlin("multiplatform") version Vers.kotlin
    `maven-publish`
}

group = "pl.mareklangiewicz.abcdk"
version = "0.0.04"

repositories {
    mavenCentral()
    maven(Repos.jitpack)
}

kotlin {
    jvm()
//    js {
//        browser()
//    }
//    linuxX64()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Deps.junit5engine)
                implementation(Deps.uspek)

            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
