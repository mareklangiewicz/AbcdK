plugins {
    id("pl.mareklangiewicz.deps")
}

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

allprojects {
    repositories {
        maven(Repos.jitpack)
        mavenCentral()
    }
}

