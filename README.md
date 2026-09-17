# AbcdK

> **Moved.** This code now lives in [KGround](https://github.com/mareklangiewicz/KGround)
> as the `:abcdk` module. This repository is archived and no longer built or released.
> The artifact id is unchanged -- `pl.mareklangiewicz:abcdk` still works -- but new versions
> come from KGround's release line, not the old 0.0.x one. Depending on `kground` is enough,
> since it api-exposes `abcdk`.

Tiny unions lib for Kotlin.

### Example
```kotlin
    fun abcdk() { 
        val a = A("a")
        val b = AB.B(2)
        val c = ABC.C('c')
        // TODO: example usage
    }
```
