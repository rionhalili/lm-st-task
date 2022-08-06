package products

import products.factory.MedicalProductFactory
import products.factory.ProductFactory
import tax.TaxType

class MedicalProduct(quantity: Int, name: String, price: Double, imported: Boolean) :
    Product(quantity, name, price, imported) {

    override fun getFactory(): ProductFactory {
        return MedicalProductFactory()
    }

    override fun getTaxValue(country: String): Double {
        return if (country == "Local") TaxType.MEDICAL_TAX.taxValue else 0.0
    }
}

