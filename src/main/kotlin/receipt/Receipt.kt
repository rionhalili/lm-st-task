package receipt

import products.Product

data class Receipt(
    val products: List<Product>,
    val salesTaxes: Double,
    val total: Double
)