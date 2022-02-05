package pl.mareklangiewicz.abcdk

import org.junit.jupiter.api.TestFactory
import pl.mareklangiewicz.uspek.uspekTestFactory


class AbcdkJvmTest {

    @TestFactory
    fun abcdkTest() = uspekTestFactory {
        OnABObjects()
        OnABCObjects()
    }
}
