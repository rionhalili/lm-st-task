package products.factory

import products.Product

abstract class ProductFactory {
    abstract fun createProduct(quantity: Int, name: String, price: Double, imported: Boolean): Product
}