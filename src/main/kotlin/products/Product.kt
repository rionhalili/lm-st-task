package products

import products.factory.ProductFactory

abstract class Product(
    val quantity: Int,
    val name: String,
    val price: Double,
    val imported: Boolean,
    var taxedCost: Double = 0.0

) {
    abstract fun getFactory(): ProductFactory
    abstract fun getTaxValue(country: String): Double

    override fun toString(): String {
        return "$quantity ${importedToString(imported)} $name $taxedCost"
    }

    open fun importedToString(imported: Boolean): String {
        return if (imported) "imported" else ""
    }
}