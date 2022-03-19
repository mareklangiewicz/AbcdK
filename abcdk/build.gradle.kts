import org.jetbrains.kotlin.gradle.dsl.*
import pl.mareklangiewicz.defaults.*

plugins {
    kotlin("multiplatform") version vers.kotlin
    id("maven-publish")
    id("signing")
}

defaultGroupAndVerAndDescription(libs.AbcdK)

repositories { defaultRepos(withGoogle = false) }

kotlin {
    jvm()
    jsDefault()
    linuxX64()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(deps.uspekx)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(deps.junit5engine)
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


defaultPublishing(libs.AbcdK)

defaultSigning()

// TODO NOW: injecting (like Andro Build Template)
// region Kotlin Multi Template

fun KotlinMultiplatformExtension.jsDefault(
    withBrowser: Boolean = true,
    withNode: Boolean = false,
    testWithChrome: Boolean = true,
    testHeadless: Boolean = true,
) {
    js(IR) {
        if (withBrowser) browser {
            testTask {
                useKarma {
                    when (testWithChrome to testHeadless) {
                        true to true -> useChromeHeadless()
                        true to false -> useChrome()
                    }
                }
            }
        }
        if (withNode) nodejs()
    }
}

// endregion Kotlin Multi Template