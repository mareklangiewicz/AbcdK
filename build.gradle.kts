// region [[Basic Root Build Imports and Plugs]]

import pl.mareklangiewicz.defaults.*
import pl.mareklangiewicz.deps.*
import pl.mareklangiewicz.utils.*
import pl.mareklangiewicz.templatefun.*

plugins {
  id("pl.mareklangiewicz.templatefun") version "0.4.28" apply false // https://plugins.gradle.org/search?term=mareklangiewicz
  plug(plugs.KotlinMulti) apply false
  plug(plugs.KotlinJvm) apply false

  // Resolve the publish plugin ONCE here, with its version. Without this the only source of
  // it is the templatefun plugin's own classpath (templatefun depends on it), which Gradle sees as
  // "unknown version" -- and then a versioned request in a subproject cannot be checked
  // against it.
  plug(plugs.VannikPublish) apply false
}

// endregion [[Basic Root Build Imports and Plugs]]

defaultGroupAndVerAndDescription(gradle.extLib)
