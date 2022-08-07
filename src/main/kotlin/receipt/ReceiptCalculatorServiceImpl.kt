package receipt

import RoundingOperation
import products.Product
import tax.TaxService

class ReceiptCalculatorServiceImpl(
    private val taxService: TaxService
) : ReceiptCalculatorService {

    override fun calculateTax(price: Double, tax: Double, imported: Boolean): Double {
        return taxService.calculateTax(price, tax, imported)
    }

    override fun calculateTotalProductPriceWithTax(price: Double, tax: Double): Double {
        return RoundingOperation.roundedValue(price + tax)
    }

    override fun calculateTotalTaxOfProducts(products: List<Product>): Double {
        var totalTax = 0.0

        products.forEach {
            totalTax += it.taxedCost - it.price
        }

        return RoundingOperation.roundedValue(totalTax)
    }

    override fun calculateTotalAmount(products: List<Product>): Double {
        var totalAmount = 0.0

        products.forEach {
            totalAmount += it.taxedCost
        }

        return totalAmount
    }

    override fun createNewReceipt(products: List<Product>, totalTax: Double, totalAmount: Double): Receipt {
        return Receipt(products, totalTax, totalAmount)
    }
}