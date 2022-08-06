package products.factory

import products.BookProduct
import products.Product

class BookProductFactory : ProductFactory() {
    override fun createProduct(quantity: Int, name: String, price: Double, imported: Boolean): Product {
        return BookProduct(quantity, name, price, imported)
    }
}