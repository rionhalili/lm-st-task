package tax

class TaxServiceFactory {
    private var taxServices: MutableMap<String, TaxService> = mutableMapOf()

    init {
        registerInFactory("Local", TaxServiceImpl())
    }

    /***
     * HEADS-UP
     * @param strategy is shadowed as for now it will always be Local
     */
    private fun registerInFactory(strategy: String, taxService: TaxService) {
        taxServices[strategy] = taxService
    }

    fun getTaxService(strategy: String): TaxService? {
        return taxServices[strategy]
    }
}