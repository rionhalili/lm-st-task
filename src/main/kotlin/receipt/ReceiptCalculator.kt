package receipt

import RoundingOperation
import products.Product
import tax.TaxService

class ReceiptCalculator(
    private val taxService: TaxService
) {

    fun calculateTax(price: Double, tax: Double, imported: Boolean): Double {
        return taxService.calculateTax(price, tax, imported)
    }

    fun calculateTotalProductPriceWithTax(price: Double, tax: Double): Double {
        return RoundingOperation.roundedValue(price + tax)
    }

    fun calculateTotalTaxOfProducts(products: List<Product>): Double {
        var totalTax = 0.0

        products.forEach { product: Product ->
            totalTax += product.taxedCost - product.price
        }

        return RoundingOperation.roundedValue(totalTax)
    }

    fun calculateTotalAmount(products: List<Product>): Double {
        var totalAmount = 0.0

        products.forEach { product: Product ->
            totalAmount += product.taxedCost
        }

        return RoundingOperation.roundedValue(totalAmount)
    }

    fun createNewReceipt(products: List<Product>, totalTax: Double, totalAmount: Double): Receipt {
        return Receipt(products, totalTax, totalAmount)
    }
}