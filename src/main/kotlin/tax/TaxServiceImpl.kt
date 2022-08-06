package tax

class TaxServiceImpl : TaxService {
    override fun calculateTax(price: Double, localTax: Double, imported: Boolean): Double {
        var tax = price * localTax
        if (imported) {
            tax += 0.05 * price
        }

        tax = RoundingOperation.roundedValue(tax)
        return tax

    }
}