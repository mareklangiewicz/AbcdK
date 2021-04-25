@file:Suppress("unused", "SpellCheckingInspection")

package pl.mareklangiewicz.abcdk

data class A<out TA>(val value: TA)

sealed class AB<out TA, out TB> {
    data class A<out TA>(val value: TA): AB<TA, Nothing>()
    data class B<out TB>(val value: TB): AB<Nothing, TB>()
}

sealed class ABC<out TA, out TB, out TC> {
    data class A<out TA>(val value: TA): ABC<TA, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABC<Nothing, TB, Nothing>()
    data class C<out TC>(val value: TC): ABC<Nothing, Nothing, TC>()
}

sealed class ABCD<out TA, out TB, out TC, out TD> {
    data class A<out TA>(val value: TA): ABCD<TA, Nothing, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABCD<Nothing, TB, Nothing, Nothing>()
    data class C<out TC>(val value: TC): ABCD<Nothing, Nothing, TC, Nothing>()
    data class D<out TD>(val value: TD): ABCD<Nothing, Nothing, Nothing, TD>()
}

sealed class ABCDE<out TA, out TB, out TC, out TD, out TE> {
    data class A<out TA>(val value: TA): ABCDE<TA, Nothing, Nothing, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABCDE<Nothing, TB, Nothing, Nothing, Nothing>()
    data class C<out TC>(val value: TC): ABCDE<Nothing, Nothing, TC, Nothing, Nothing>()
    data class D<out TD>(val value: TD): ABCDE<Nothing, Nothing, Nothing, TD, Nothing>()
    data class E<out TE>(val value: TE): ABCDE<Nothing, Nothing, Nothing, Nothing, TE>()
}

sealed class ABCDEF<out TA, out TB, out TC, out TD, out TE, out TF> {
    data class A<out TA>(val value: TA): ABCDEF<TA, Nothing, Nothing, Nothing, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABCDEF<Nothing, TB, Nothing, Nothing, Nothing, Nothing>()
    data class C<out TC>(val value: TC): ABCDEF<Nothing, Nothing, TC, Nothing, Nothing, Nothing>()
    data class D<out TD>(val value: TD): ABCDEF<Nothing, Nothing, Nothing, TD, Nothing, Nothing>()
    data class E<out TE>(val value: TE): ABCDEF<Nothing, Nothing, Nothing, Nothing, TE, Nothing>()
    data class F<out TF>(val value: TF): ABCDEF<Nothing, Nothing, Nothing, Nothing, Nothing, TF>()
}

sealed class ABCDEFG<out TA, out TB, out TC, out TD, out TE, out TF, out TG> {
    data class A<out TA>(val value: TA): ABCDEFG<TA, Nothing, Nothing, Nothing, Nothing, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABCDEFG<Nothing, TB, Nothing, Nothing, Nothing, Nothing, Nothing>()
    data class C<out TC>(val value: TC): ABCDEFG<Nothing, Nothing, TC, Nothing, Nothing, Nothing, Nothing>()
    data class D<out TD>(val value: TD): ABCDEFG<Nothing, Nothing, Nothing, TD, Nothing, Nothing, Nothing>()
    data class E<out TE>(val value: TE): ABCDEFG<Nothing, Nothing, Nothing, Nothing, TE, Nothing, Nothing>()
    data class F<out TF>(val value: TF): ABCDEFG<Nothing, Nothing, Nothing, Nothing, Nothing, TF, Nothing>()
    data class G<out TG>(val value: TG): ABCDEFG<Nothing, Nothing, Nothing, Nothing, Nothing, Nothing, TG>()
}

@Deprecated("Really?")
fun ABCDEFGH(): Nothing = error("Really?")

@Deprecated("Really?")
fun ABCDEFGHI(): Nothing = error("Really?")

@Deprecated("Really?")
fun ABCDEFGHIJ(): Nothing = error("Really?")

@Deprecated("Really?")
fun ABCDEFGHIJK(): Nothing = error("Really?")


