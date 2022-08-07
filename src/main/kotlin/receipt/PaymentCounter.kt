package receipt

import products.Product
import tax.TaxServiceFactory

class PaymentCounter(
    private var receiptCalculator: ReceiptCalculatorServiceImpl,
    private var receipt: Receipt,
    private var products: List<Product>,
    private val strategy: String
){
    fun billItems(shoppingCart: ShoppingCart) {
        products = shoppingCart.products

        products.forEach {
            receiptCalculator = calculateReceiptBasedOnStrategy(strategy)
            val productTax = receiptCalculator.calculateTax(it.price, it.getTaxValue(strategy), it.imported)
            val taxedCost = receiptCalculator.calculateTotalProductPriceWithTax(it.price, productTax)
            it.taxedCost = taxedCost
        }
    }

    fun getReceipt(): Receipt {
        val totalTax = receiptCalculator.calculateTotalTaxOfProducts(products)
        val totalAmount = receiptCalculator.calculateTotalAmount(products)
        receipt = receiptCalculator.createNewReceipt(products, totalTax, totalAmount)
        return receipt
    }

    private fun calculateReceiptBasedOnStrategy(strategy: String): ReceiptCalculatorServiceImpl {
        val factory = TaxServiceFactory()
        val taxService = factory.getTaxService(strategy)
        return ReceiptCalculatorServiceImpl(taxService!!)
    }
}