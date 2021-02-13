interface ILaptopCRUD {
    fun addLaptopNew(financialReports: FinancialReports, transactionReports: TrasactionReports)
    fun addLaptopOld(financialReports: FinancialReports, transactionReports: TrasactionReports)
    fun sellLaptop(financialReports: FinancialReports, transactionReports: TrasactionReports)
    fun sellLaptopAll(financialReports: FinancialReports, transactionReports: TrasactionReports)
    fun lookLaptopAll()
    fun lookLaptopBrand()
    fun lookLaptopRam()
    fun lookLaptopRom()
    fun lookLaptopPrice()
    fun updateLaptop()
    fun removeLaptop()
    fun sortLaptopPrice()
    fun sortLaptopRam()
    fun sortLaptopRom()
    fun sortLaptopBrand()
    fun getLaptopList():MutableList<Laptop>
    fun setLaptopList(newLaptopList:MutableList<Laptop>)
    fun getLaptopListTrash():MutableList<Laptop>
    fun setLaptopListTrash(newLaptopList:MutableList<Laptop>)
    fun getAllPrice():Long
}