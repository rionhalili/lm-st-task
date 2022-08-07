package tax

class TaxServiceImpl : TaxService {
    override fun calculateTax(price: Double, localTax: Double, imported: Boolean): Double {
        var tax = price * localTax
        if (imported) {
            tax += IMPORT_DUTY * price
        }

        tax = RoundingOperation.roundedValue(tax)
        return tax
    }

    companion object {
        private const val IMPORT_DUTY = 0.05
    }
}