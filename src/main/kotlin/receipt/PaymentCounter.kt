package receipt

import products.Product
import tax.TaxServiceFactory

class PaymentCounter(
    private var receiptCalculator: ReceiptCalculator,
    private var products: List<Product>,
    private val country: String
){
    fun billItems(shoppingCart: ShoppingCart) {
        products = shoppingCart.products

        products.forEach { product: Product ->
            receiptCalculator = calculateReceiptBasedOnStrategy(country)
            val productTax = receiptCalculator.calculateTax(product.price, product.getTaxValue(country), product.imported)
            val taxedCost = receiptCalculator.calculateTotalProductPriceWithTax(product.price, productTax)
            product.taxedCost = taxedCost
        }
    }

    fun getReceipt(): Receipt {
        val totalTax = receiptCalculator.calculateTotalTaxOfProducts(products)
        val totalAmount = receiptCalculator.calculateTotalAmount(products)
        return receiptCalculator.createNewReceipt(products, totalTax, totalAmount)
    }

    private fun calculateReceiptBasedOnStrategy(strategy: String): ReceiptCalculator {
        val factory = TaxServiceFactory()
        val taxCal = factory.getTaxService(strategy)
        return ReceiptCalculator(taxCal!!)
    }
}