package products

import products.factory.OtherProductsFactory
import products.factory.ProductFactory
import tax.TaxType

class OtherProduct(quantity: Int, name: String, price: Double, imported: Boolean) :
    Product(quantity, name, price, imported) {

    override fun getFactory(): ProductFactory {
        return OtherProductsFactory()
    }

    override fun getTaxValue(country: String): Double {
        return if (country == "Local") TaxType.OTHER_TAX.taxValue else 0.0
    }
}
