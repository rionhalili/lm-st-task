package products.factory

import products.FoodProduct
import products.Product

class FoodProductFactory : ProductFactory() {
    override fun createProduct(quantity: Int, name: String, price: Double, imported: Boolean): Product {
        return FoodProduct(quantity, name, price, imported)
    }
}