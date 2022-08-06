import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(PER_CLASS)
internal class RoundingOperationTest {

    @ParameterizedTest
    @MethodSource("differentDoubleValues")
    fun `should return correct values from rounding operation`(value: Double, result: Double) {
        val roundingOperation = RoundingOperation.roundedValue(value)
        assertThat(roundingOperation).isEqualTo(result)

    }

    private fun differentDoubleValues(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(00.01, 0.0),
            Arguments.of(1.34567, 1.35),
        )
    }
}