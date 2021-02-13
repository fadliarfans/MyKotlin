
class SecondPage {
    private val laptopRepository = LaptopRepository()
    private val financialReports = FinancialReports()
    private val transactionReports = TrasactionReports()

    fun sellLaptop(){
        while(true) {
            println("""
                
            Penjualan Laptop
            
            1. Jual Laptop
            2. Jual Semua Laptop
            3. Balik ke Menu Utama
            
        """.trimIndent())
            print("Input : ")
            when (readLine()?.toInt() ?: 0) {
                1 -> laptopRepository.sellLaptop(financialReports, transactionReports)
                2 -> laptopRepository.sellLaptopAll(financialReports, transactionReports)
                3 -> break
            }
        }
    }

    fun addLaptop() {
        while (true) {
            println("""
            
                Penambahan Laptop
            
                1. Tambah Laptop Baru
                2. Tambah Laptop Yang sudah Ada
                3. Balik ke Menu Utama
            
            """.trimIndent())
            print("Input : ")
            when (readLine()?.toInt()) {
                1 -> laptopRepository.addLaptopNew(financialReports, transactionReports)
                2 -> laptopRepository.addLaptopOld(financialReports, transactionReports)
                3 -> break
            }
        }
    }

    fun lookLaptop() {
        while (true) {
            println("""
                
            Melihat Laptop
            
            1. lihat semua laptop
            2. lihat laptop berdasarkan merek
            3. lihat laptop berdasarkan rom
            4. lihat laptop berdasarkan ram
            5. lihat laptop berdasarkan harga
            6. Balik Ke Menu Utama
            
        """.trimIndent())
            print("input : ")
            when(readLine()?.toInt()?:0){
                1 -> laptopRepository.lookLaptopAll()
                2 -> laptopRepository.lookLaptopBrand()
                3 -> laptopRepository.lookLaptopRom()
                4 -> laptopRepository.lookLaptopRam()
                5 -> laptopRepository.lookLaptopPrice()
                6 -> break
            }
        }
    }

    fun sortLaptop() {

        println("""
            
            Mengurutkan Laptop
            
            1. Berdasarkan Harga
            2. Berdasarkan Ram
            3. Berdasarkan Rom
            4. Berdasarkan Merek
            5. Balik Ke Menu Utama
            
        """.trimIndent())
        print("input : ")
        when (readLine()?.toInt() ?: 0) {
            1 -> {laptopRepository.sortLaptopPrice()
                lookLaptop()}
            2 -> {laptopRepository.sortLaptopRam()
                lookLaptop()}
            3 -> {laptopRepository.sortLaptopRom()
                lookLaptop()}
            4 -> {laptopRepository.sortLaptopBrand()
                lookLaptop()}
        }

    }

    fun updateLaptop(){
        while(true) {
            println("""
                
            Pembaruan Laptop
            
            1. Perbarui Data Laptop
            2. Balik ke Menu Utama
            
        """.trimIndent())
            print("Input : ")
            when (readLine()?.toInt() ?: 0) {
                1 -> laptopRepository.updateLaptop()
                2 -> break
            }
        }
    }

    fun removeLaptop(){
        while (true) {
            println("""
            
            Buang Laptop 
            
            1. Buang Laptop 
            2. Balik Ke Menu Utama
            
        """.trimIndent())
            print("input : ")
            when(readLine()?.toInt()?:0){
                1 -> laptopRepository.removeLaptop()
                2 -> break
            }
        }
    }

    fun transactionReports(){
        while(true) {
            println("""
                
            Laporan Transaksi
            
            1. Transaksi Penjualan
            2. Transaksi Pembelian
            3. Membatalkan Transaksi Penjualan
            4. Membatalkan Transaksi Pembelian
            5. Balik Ke Menu Utama
            
        """.trimIndent())
            print("Input : ")
            when (readLine()?.toInt() ?: 0) {
                1 -> transactionReports.readSellingTransaction()
                2 -> transactionReports.readBuyingTransaction()
                3 -> transactionReports.cancelSellingTransaction(laptopRepository, financialReports)
                4 -> transactionReports.cancelBuyingTransaction(laptopRepository, financialReports)
                5 -> break
            }
        }
    }

    fun financialReports(){
        while(true) {
            println("""
                
            Laporan Keuangan
            
            1. Total Uang Kas
            2. Total Kekayaan
            3. Menambah Uang Kas
            4. Mengurang Uang Kas
            5. Balik Ke Menu Utama
            
        """.trimIndent())
            print("Input : ")
            when (readLine()?.toInt() ?: 0) {
                1 -> financialReports.getMoneyTotalRp()
                2 -> { financialReports.setWealthTotal(laptopRepository)
                    financialReports.getWealthTotalRp()}
                3 -> financialReports.plusMoneyTotal()
                4 -> financialReports.minusMoneyTotal()
                5 -> break
            }
        }
    }

}