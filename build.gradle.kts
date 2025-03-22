
// region [[Basic Root Build Imports and Plugs]]

import pl.mareklangiewicz.defaults.*
import pl.mareklangiewicz.utils.*
import pl.mareklangiewicz.deps.*

plugins {
  plug(plugs.KotlinMulti) apply false
  plug(plugs.KotlinJvm) apply false
}

// endregion [[Basic Root Build Imports and Plugs]]

val enableJs = true
val enableNative = true

defaultBuildTemplateForRootProject(
    myLibDetails(
        name = "AbcdK",
        description = "Tiny unions lib for Kotlin.",
        githubUrl = "https://github.com/mareklangiewicz/AbcdK",
        version = Ver(0, 0, 30),
        // https://central.sonatype.com/artifact/pl.mareklangiewicz/abcdk
        // https://github.com/mareklangiewicz/AbcdK/releases
        settings = LibSettings(
            withJs = enableJs,
            withNativeLinux64 = enableNative,
            compose = null,
            withSonatypeOssPublishing = true,
        ),
    ),
)

// region [[Root Build Template]]

fun Project.defaultBuildTemplateForRootProject(details: LibDetails? = null) {
  details?.let {
    rootExtLibDetails = it
    defaultGroupAndVerAndDescription(it)
  }

  // kinda workaround for kinda issue with kotlin native
  // https://youtrack.jetbrains.com/issue/KT-48410/Sync-failed.-Could-not-determine-the-dependencies-of-task-commonizeNativeDistribution.#focus=Comments-27-5144160.0-0
  repositories { mavenCentral() }
}

// endregion [[Root Build Template]]
