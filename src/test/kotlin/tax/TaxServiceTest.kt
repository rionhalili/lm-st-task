package tax

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TaxServiceTest {

    @Test
    fun `should calculate tax correctly when product is not imported`() {
        val taxService = TaxServiceImpl()
        val taxCalculationTotal = taxService.calculateTax(1.0, 0.20, false)

        assertThat(taxCalculationTotal).isEqualTo(0.2)
    }

    @Test
    fun `should calculate tax correctly when product is imported`() {
        val taxService = TaxServiceImpl()
        val taxCalculationTotal = taxService.calculateTax(1.0, 0.20, true)

        assertThat(taxCalculationTotal).isEqualTo(0.71)
    }
}