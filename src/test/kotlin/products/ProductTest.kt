package products

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import tax.TaxType.*
import java.util.stream.Stream

@TestInstance(PER_CLASS)
internal class ProductTest {

    @Test
    internal fun `should return empty string when imported is false`() {
        val product = BookProduct(
            quantity = 1,
            name = "book",
            price = 12.49,
            imported = false
        )
        val imported = product.importedToString(product.imported)
        assertThat(imported)
            .isEqualTo("")
    }

    @Test
    fun `should return imported string when imported is true`() {
        val product = BookProduct(
            quantity = 1,
            name = "book",
            price = 12.49,
            imported = true
        )
        val imported = product.importedToString(product.imported)
        assertThat(imported)
            .isEqualTo("imported")
    }

    @ParameterizedTest
    @MethodSource("productsWithTaxValues")
    fun `should return correct tax type values from different products`(product: Product, taxTypeValue: Double) {
        val taxValue = product.getTaxValue("Local")
        assertThat(taxValue)
            .isEqualTo(taxTypeValue)
    }

    private fun productsWithTaxValues(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                BookProduct(
                    quantity = 1,
                    name = "book",
                    price = 12.49,
                    imported = true
                ),
                BOOK_TAX.taxValue
            ),
            Arguments.of(
                FoodProduct(
                    quantity = 1,
                    name = "box of chocolates",
                    price = 11.25,
                    imported = true
                ),
                FOOD_TAX.taxValue
            ),
            Arguments.of(
                MedicalProduct(
                    quantity = 1,
                    name = "package of headache pills",
                    price = 9.75,
                    imported = false
                ),
                MEDICAL_TAX.taxValue
            ),
            Arguments.of(
                OtherProduct(
                    quantity = 1,
                    name = "bottle of perfume",
                    price = 18.99,
                    imported = false
                ),
                OTHER_TAX.taxValue
            ),
        )
    }

}