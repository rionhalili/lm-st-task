package tax

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TaxServiceFactoryTest {

    @Test
    fun `should return correct tax service when strategy type exists`() {
        val taxServiceFactory = TaxServiceFactory()
        val taxService = taxServiceFactory.getTaxService("Local")

        assertThat(taxService).isNotNull
    }

    @Test
    fun `should return null when strategy type does not exists`() {
        val taxServiceFactory = TaxServiceFactory()
        val taxService = taxServiceFactory.getTaxService("Non-existent-strategy")

        assertThat(taxService).isNull()
    }
}