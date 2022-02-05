plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

defaultGroupAndVer(Deps.abcdk)

repositories {
    defaultRepos(withMavenLocal = true)
}

kotlin {
    jvm()
    jsDefault()
    linuxX64()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Deps.uspekx)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(Deps.junit5engine)
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
