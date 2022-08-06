package tax

enum class TaxType(val taxValue: Double) {
    BOOK_TAX(0.0),
    FOOD_TAX(0.0),
    MEDICAL_TAX(0.0),
    OTHER_TAX(0.10)
}