package pl.mareklangiewicz.abcdk

sealed class AB<out TA, out TB> {
    data class A<out TA>(val value: TA): AB<TA, Nothing>()
    data class B<out TB>(val value: TB): AB<Nothing, TB>()
}

sealed class ABC<out TA, out TB, out TC> {
    data class A<out TA>(val value: TA): ABC<TA, Nothing, Nothing>()
    data class B<out TB>(val value: TB): ABC<Nothing, TB, Nothing>()
    data class C<out TC>(val value: TC): ABC<Nothing, Nothing, TC>()
}


