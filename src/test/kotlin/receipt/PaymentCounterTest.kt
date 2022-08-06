package receipt

import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import products.BookProduct
import products.FoodProduct
import products.MedicalProduct
import products.OtherProduct
import tax.TaxService

internal class PaymentCounterTest {

    private val taxService: TaxService = mock(TaxService::class.java)

    /**
    Input 1:
    1 book at 12.49
    1 music CD at 14.99
    1 chocolate bar at 0.85
     */
    @Test
    fun `given products from input 1 should return full receipt with Sales Taxes and Total`() {
        val products = listOf(
            BookProduct(
                quantity = 1,
                name = "book",
                price = 12.49,
                imported = false
            ),
            OtherProduct(
                quantity = 1,
                name = "music CD",
                price = 14.99,
                imported = false
            ),
            FoodProduct(
                quantity = 1,
                name = "chocolate bar",
                price = 0.85,
                imported = false
            )
        )

        val receiptCalculator = ReceiptCalculator(taxService)
        val receipt1 = Receipt(products, 0.0, 0.0)
        val paymentCounter = PaymentCounter(receiptCalculator, receipt1, products, "Local")

        val shoppingCart = ShoppingCart(products)
        paymentCounter.billItems(shoppingCart)

        val receipt = paymentCounter.getReceipt()

        assertSoftly { softly ->
            softly.assertThat(receipt.products.size).isEqualTo(3)
            softly.assertThat(receipt.salesTaxes).isEqualTo(1.5)
            softly.assertThat(receipt.total).isEqualTo(29.85)

            softly.assertThat(receipt.toString())
                .isEqualToIgnoringWhitespace(
                    "\n\n" +
                            "===============================\n" +
                            "RECEIPT\n" +
                            "===============================\n" +
                            "1  book 12.5\n" +
                            "1  music CD 16.5\n" +
                            "1  chocolate bar 0.85\n" +
                            "Sales taxes: 1.5\n" +
                            "Total: 29.85\n" +
                            "===============================\n"
                )
        }
    }

    /**
    Input 2:
    1 imported box of chocolates at 10.00
    1 imported bottle of perfume at 47.50
     */
    @Test
    fun `given products from input 2 should return full receipt with Sales Taxes and Total`() {
        val products = listOf(
            FoodProduct(
                quantity = 1,
                name = "box of chocolates",
                price = 10.00,
                imported = true
            ),
            OtherProduct(
                quantity = 1,
                name = "bottle of perfume",
                price = 47.50,
                imported = true
            ),
        )

        val receiptCalculator = ReceiptCalculator(taxService)
        val receipt1 = Receipt(products, 0.0, 0.0)
        val paymentCounter = PaymentCounter(receiptCalculator, receipt1, products, "Local")

        val shoppingCart = ShoppingCart(products)
        paymentCounter.billItems(shoppingCart)

        val receipt = paymentCounter.getReceipt()

        assertSoftly { softly ->
            softly.assertThat(receipt.products.size).isEqualTo(2)
            softly.assertThat(receipt.salesTaxes).isEqualTo(7.65)
            softly.assertThat(receipt.total).isEqualTo(65.15)

            softly.assertThat(receipt.toString())
                .isEqualToIgnoringWhitespace(
                    "\n\n" +
                            "===============================\n" +
                            "RECEIPT\n" +
                            "===============================\n" +
                            "1 imported box of chocolates 10.5\n" +
                            "1 imported bottle of perfume 54.65\n" +
                            "Sales taxes: 7.65\n" +
                            "Total: 65.15\n" +
                            "===============================\n"
                )
        }
    }

    /**
    Input 3:
    1 imported bottle of perfume at 27.99
    1 bottle of perfume at 18.99
    1 packet of headache pills at 9.75
    1 box of imported chocolates at 11.25
     */
    @Test
    fun `given products from input 3 should return full receipt with Sales Taxes and Total`() {
        val products = listOf(
            OtherProduct(
                quantity = 1,
                name = "bottle of perfume",
                price = 27.99,
                imported = true
            ),
            OtherProduct(
                quantity = 1,
                name = "bottle of perfume",
                price = 18.99,
                imported = false
            ),
            MedicalProduct(
                quantity = 1,
                name = "package of headache pills",
                price = 9.75,
                imported = false
            ),
            FoodProduct(
                quantity = 1,
                name = "box of chocolates",
                price = 11.25,
                imported = true
            )
        )

        val receiptCalculator = ReceiptCalculator(taxService)
        val receipt1 = Receipt(products, 0.0, 0.0)
        val paymentCounter = PaymentCounter(receiptCalculator, receipt1, products, "Local")

        val shoppingCart = ShoppingCart(products)
        paymentCounter.billItems(shoppingCart)

        val receipt = paymentCounter.getReceipt()

        assertSoftly { softly ->
            softly.assertThat(receipt.products.size).isEqualTo(4)
            softly.assertThat(receipt.salesTaxes).isEqualTo(6.65)
            softly.assertThat(receipt.total).isEqualTo(74.65)

            softly.assertThat(receipt.toString())
                .isEqualToIgnoringWhitespace(
                    "\n\n" +
                            "===============================\n" +
                            "RECEIPT\n" +
                            "===============================\n" +
                            "1 imported bottle of perfume 32.2\n" +
                            "1  bottle of perfume 20.9\n" +
                            "1  package of headache pills 9.75\n" +
                            "1 imported box of chocolates 11.8\n" +
                            "Sales taxes: 6.65\n" +
                            "Total: 74.65\n" +
                            "===============================\n"
                )
        }
    }
}