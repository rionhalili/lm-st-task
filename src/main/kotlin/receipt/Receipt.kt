package receipt

import products.Product

data class Receipt(
    val products: List<Product> = listOf(),
    val salesTaxes: Double = 0.0,
    val total: Double = 0.0
) {

    override fun toString(): String {
        var receipt = "\n\n"
        receipt += "===============================\n"
        receipt += "RECEIPT\n"
        receipt += "===============================\n"
        products.forEach { product ->
            receipt += product.toString() + "\n"
        }
        receipt += "Sales taxes: $salesTaxes\n"
        receipt += "Total: $total\n"
        receipt += "===============================\n"

        return receipt
    }
}