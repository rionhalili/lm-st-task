package receipt

import products.Product

interface ReceiptCalculatorService {
    fun calculateTax(price: Double, tax: Double, imported: Boolean): Double
    fun calculateTotalProductPriceWithTax(price: Double, tax: Double): Double
    fun calculateTotalTaxOfProducts(products: List<Product>): Double
    fun calculateTotalAmount(products: List<Product>): Double
    fun createNewReceipt(products: List<Product>, totalTax: Double, totalAmount: Double): Receipt
}