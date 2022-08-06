package products.factory

import products.MedicalProduct
import products.Product

class MedicalProductFactory : ProductFactory() {
    override fun createProduct(quantity: Int, name: String, price: Double, imported: Boolean): Product {
        return MedicalProduct(quantity, name, price, imported)
    }
}