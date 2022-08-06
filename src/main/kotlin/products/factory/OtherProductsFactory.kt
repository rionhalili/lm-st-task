package products.factory

import products.OtherProduct
import products.Product

class OtherProductsFactory : ProductFactory() {
    override fun createProduct(quantity: Int, name: String, price: Double, imported: Boolean): Product {
        return OtherProduct(quantity, name, price, imported)
    }
}