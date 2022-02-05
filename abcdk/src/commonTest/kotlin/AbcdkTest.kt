@file:Suppress("TestFunctionName")

package pl.mareklangiewicz.abcdk

import pl.mareklangiewicz.uspek.*
import kotlin.test.*


/**
 * Note: Use IDE type hints to see how covariant union types are inferred by compiler.
 * Note: This is more like a playground than tests - most tests can never fail and are here to see IDE type hints.
 */
class AbcdkTest {

    @Test
    fun abcdkTest() = uspek {
        OnABObjects()
        OnABCObjects()
    }
}

fun OnABObjects() {
    "On AB objects" o {
        val a = A("a")
        val b = AB.B(2)
        val x = AB.B(666f)

        "b is AB and compiler knows it" o {
            @Suppress("USELESS_IS_CHECK")
            b is AB<*, *>
        }

        "On AB lists" o {
            val lista = listOf(a)
            val listb = listOf(b)
            val listx = listOf(x)
            val listab = listOf(a, b)

            "lista + listb + listab is List<AB<String, Int>>" o { val l = lista + listb + listab }
            "lista + listx is List<AB<String, Float>>" o { val l = lista + listx }
            "listb + listx is List<AB.B<Any>>" o { val l = listb + listx }
        }
    }
}

fun OnABCObjects() {
    "On ABC objects" o {
        val a = ABC.A("a")
        val b = ABC.B(2)
        val c = ABC.C('c')
        val x = ABC.A(666f)
        val y = ABC.B(777.0)
        val z = ABC.C(8 to 9)

        "On some ABC lists" o {
            val la = listOf(a)
            val lb = listOf(b)
            val lc = listOf(c)
            val lx = listOf(x)
            val ly = listOf(y)
            val lz = listOf(z)

            "infer some common types" o {
                val l1 = la + lb
                val l2 = lc + lx
                val l3 = l1 + l2 + ly
                val l4 = l3 + z
            }
        }
    }
}
