package products

import products.factory.BookProductFactory
import products.factory.ProductFactory
import tax.TaxType

class BookProduct(quantity: Int, name: String, price: Double, imported: Boolean) :
    Product(quantity, name, price, imported) {

    override fun getFactory(): ProductFactory {
        return BookProductFactory()
    }

    override fun getTaxValue(country: String): Double {
        return if(country == "Local") TaxType.BOOK_TAX.taxValue else 0.0
    }
}