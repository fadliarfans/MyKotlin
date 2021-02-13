

fun main(){
    while(true){
    println("""
        
    Program Database Toko Laptop
    
    1. Jual Laptop
    2. Tambah Laptop
    3. Lihat Laptop
    4. Urutkan Laptop
    5. Perbarui Laptop
    6. Buang Laptop
    7. Lihat Laporan Transaksi
    8. Lihat Laporan Keuangan
    9. Exit
    
""".trimIndent())
    print("Input : ")
    val secondPage = SecondPage()
    when(readLine()?.toInt()){
        1 -> secondPage.sellLaptop()
        2 -> secondPage.addLaptop()
        3 -> secondPage.lookLaptop()
        4 -> secondPage.sortLaptop()
        5 -> secondPage.updateLaptop()
        6 -> secondPage.removeLaptop()
        7 -> secondPage.transactionReports()
        8 -> secondPage.financialReports()
        9 -> break
    }

    }
}

