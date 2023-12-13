
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("pl.mareklangiewicz.deps.settings") version "0.2.69" // https://plugins.gradle.org/search?term=mareklangiewicz
    id("com.gradle.enterprise") version "3.16" // https://docs.gradle.com/enterprise/gradle-plugin/
}

rootProject.name = "AbcdK"

include(":abcdk")