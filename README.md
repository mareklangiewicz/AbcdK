# TupleK
Tiny tuples lib for Kotlin with cool infix syntax.

Stolen from Jesse Wilson gist:
- https://gist.github.com/swankjesse/095ccdcc7a95621f499b3548fc944b6d


### Example
```kotlin
    fun tuplek() { 
        println("a" to "b")
        println("a" to "b" tre "c")
        println("a" to "b" tre "c" fo "d")
        println("a" to "b" tre "c" fo "d" fi "e")
        println("a" to "b" tre "c" fo "d" fi "e" sik "f")
        println("a" to "b" tre "c" fo "d" fi "e" sik "f" seva "g")
    }
```

[![](https://jitpack.io/v/langara/TupleK.svg)](https://jitpack.io/#langara/TupleK)

### Building with JitPack
```gradle
    repositories {
        maven { url "https://jitpack.io" }
    }
   
    dependencies {
        testImplementation 'com.github.langara:TupleK:master-SNAPSHOT'
    }
```

details: https://jitpack.io/#langara/TupleK
