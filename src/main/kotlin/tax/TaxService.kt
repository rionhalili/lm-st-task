package tax

interface TaxService {
    fun calculateTax(price: Double, localTax: Double, imported: Boolean): Double
}