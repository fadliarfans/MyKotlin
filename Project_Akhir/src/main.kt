

fun main(){

println("""
    Program Database Toko Laptop
    
    1. Jual Laptop
    2. Tambah Laptop
    3. Lihat Laptop
    4. Lihat Laporan Transaksi
    5. Lihat Laporan Keuangan
    6. Exit
""".trimIndent())
    val repositoryLaptop = RepositoryLaptop()
    print(repositoryLaptop.laptopList[0])
}

