
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
        version = Ver(0, 0, 34),
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
}

// endregion [[Root Build Template]]
