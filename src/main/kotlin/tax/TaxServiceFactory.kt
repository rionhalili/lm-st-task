package tax

class TaxServiceFactory {
    private var taxServices: MutableMap<String, TaxService> = mutableMapOf()

    init {
        registerInFactory("Local", TaxServiceImpl())
    }

    private fun registerInFactory(strategy: String, taxService: TaxService) {
        taxServices[strategy] = taxService
    }

    fun getTaxService(strategy: String): TaxService? {
        return taxServices[strategy]
    }
}