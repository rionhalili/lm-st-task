package products

import products.factory.FoodProductFactory
import products.factory.ProductFactory
import tax.TaxType

class FoodProduct(quantity: Int, name: String, price: Double, imported: Boolean) :
    Product(quantity, name, price, imported) {

    override fun getFactory(): ProductFactory {
        return FoodProductFactory()
    }

    override fun getTaxValue(country: String): Double {
        return if(country == "Local") TaxType.FOOD_TAX.taxValue else 0.0
    }
}
