@file:Suppress("UnstableApiUsage")
@file:OptIn(okio.ExperimentalFileSystem::class)

import okio.Path.Companion.toOkioPath

gradle.logSomeEventsToFile(rootProject.projectDir.toOkioPath() / "my.gradle.log")


pluginManagement {
    includeBuild("../deps.kt")
}

plugins {
    id("pl.mareklangiewicz.deps.settings")
}

include(":abcdk")
