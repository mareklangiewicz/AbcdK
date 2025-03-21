
// region [[Basic Root Build Imports and Plugs]]

import pl.mareklangiewicz.defaults.*
import pl.mareklangiewicz.utils.*
import pl.mareklangiewicz.deps.*

plugins {
  plug(plugs.KotlinMulti) apply false
  plug(plugs.KotlinJvm) apply false
}

// endregion [[Basic Root Build Imports and Plugs]]

// New issue with js and native (unresolved references in common code)
// TODO: try again after deps update
val enableJs = true
val enableNative = true

defaultBuildTemplateForRootProject(
    myLibDetails(
        name = "AbcdK",
        description = "Tiny unions lib for Kotlin.",
        githubUrl = "https://github.com/mareklangiewicz/AbcdK",
        version = Ver(0, 0, 29),
        // https://s01.oss.sonatype.org/content/repositories/releases/pl/mareklangiewicz/abcdk/
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

/** Publishing to Sonatype OSSRH has to be explicitly allowed here, by setting withSonatypeOssPublishing to true. */
fun Project.defaultBuildTemplateForRootProject(details: LibDetails? = null) {
  ext.addDefaultStuffFromSystemEnvs()
  details?.let {
    rootExtLibDetails = it
    defaultGroupAndVerAndDescription(it)
  }

  // kinda workaround for kinda issue with kotlin native
  // https://youtrack.jetbrains.com/issue/KT-48410/Sync-failed.-Could-not-determine-the-dependencies-of-task-commonizeNativeDistribution.#focus=Comments-27-5144160.0-0
  repositories { mavenCentral() }
}

/**
 * System.getenv() should contain env variables with given prefix, like:
 * MYKOTLIBS_signingInMemoryKeyId (probably only mandatory when using subkey)
 * MYKOTLIBS_signingInMemoryKeyPassword
 * And either:
 * MYKOTLIBS_signingInMemoryKey (with full ascii-armored key)
 * Or (note it's "ToMemory" to emphasize it will be read from file to memory first):
 * MYKOTLIBS_signingToMemoryKeyFile (file with key which is read and copied to signingInMemoryKey ext property here)
 *
 * Resulting ext properties: signingInMemoryKeyId, signingInMemoryKeyPassword and signingInMemoryKey,
 * will be automatically found and consumed by signing plugin in each subproject/module.
 * See details in fun: com.vanniktech.maven.publish.MavenPublishBaseExtension.signAllPublications
 */
fun ExtraPropertiesExtension.addDefaultStuffFromSystemEnvs(envKeyMatchPrefix: String = "MYKOTLIBS_") {
    addAllFromSystemEnvs(envKeyMatchPrefix)
    if (!has("signingInMemoryKey") && has("signingToMemoryKeyFile"))
        set("signingInMemoryKey", rootExtReadFileUtf8("signingToMemoryKeyFile"))
}

// endregion [[Root Build Template]]
