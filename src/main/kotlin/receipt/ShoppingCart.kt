package receipt

import products.Product

/***
 * HEADS-UP
 * ShoppingCart is just a cosmetic class to provide clarity in the example
 */
data class ShoppingCart(
    val products: List<Product>
)