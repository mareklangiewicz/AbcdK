@file:Suppress("UnstableApiUsage")

import okio.Path.Companion.toOkioPath
import pl.mareklangiewicz.evts.*

gradle.logSomeEventsToFile(rootProject.projectDir.toOkioPath() / "my.gradle.log")


pluginManagement {
    includeBuild("../deps.kt")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("pl.mareklangiewicz.deps.settings")
}

rootProject.name = "AbcdK"

include(":abcdk")