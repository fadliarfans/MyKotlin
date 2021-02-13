import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.text.DecimalFormat
import java.text.NumberFormat


class TrasactionReports {
    private val gson = Gson()
    private val mutableListTypeSelling= object : TypeToken<MutableList<TransactionSelling>>() {}.type!!
    private val mutableListTypeBuying = object : TypeToken<MutableList<TransactionBuying>>() {}.type!!
    private var transactionSellingList:MutableList<TransactionSelling> = gson.fromJson(FileReader("src/assets/DataSellingTransaction.json"),mutableListTypeSelling)
    private var trasactionBuyingList:MutableList<TransactionBuying> = gson.fromJson(FileReader("src/assets/DataBuyingTransaction.json"),mutableListTypeBuying)

    private var fileDataTransactionSelling = File("src/assets/DataSellingTransaction.json")
    private var fileDataTransactionBuying = File("src/assets/DataBuyingTransaction.json")

    private var gsonPresetableWrite = GsonBuilder().setPrettyPrinting().create()!!
    private var gsonTransactionSellingList = gsonPresetableWrite.toJson(transactionSellingList)
    private var gsonTransactionBuyingList = gsonPresetableWrite.toJson(trasactionBuyingList)

    private fun Long.toRupiah():String{
        val formatter: NumberFormat = DecimalFormat("#,###")
        val moneyRupiah = formatter.format(this)
        return "Rp $moneyRupiah"
    }
    private fun isOK():Boolean{
        print("\nApakah Anda Sudah Yakin [Y/N] : ")
        var input = readLine()?:""
        input = input.toUpperCase()
        return  input == "Y"
    }

    fun addSellingTransaction(date: String, totalTipeYangDijual:Int, totalLaptopYangDijual:Int, totalHarga:Long, totalKeuntungan:Long, laptopListBackup: LaptopPrimaryList){
        transactionSellingList.add(TransactionSelling(date, totalTipeYangDijual, totalLaptopYangDijual, totalHarga, totalKeuntungan,laptopListBackup))
        gsonTransactionSellingList = gsonPresetableWrite.toJson(transactionSellingList)
        fileDataTransactionSelling.writeText(gsonTransactionSellingList)
    }

    fun addBuyingTransaction(date: String, totalTipeYangDibeli:Int, totalLaptopYangDibeli: Int, totalHarga:Long, laptopListBackup: LaptopPrimaryList){
        trasactionBuyingList.add(TransactionBuying(date, totalTipeYangDibeli, totalLaptopYangDibeli, totalHarga, laptopListBackup ))
        gsonTransactionBuyingList = gsonPresetableWrite.toJson(trasactionBuyingList)
        fileDataTransactionBuying.writeText(gsonTransactionBuyingList)
    }

    fun readSellingTransaction(){
        println(" Transaksi Penjualan Laptop \n")
        System.out.format("|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
        System.out.format("|   %15s           | %10s | %12s | %19s   | %19s   |  %17s  |\n","Tanggal","Total Tipe","Total Laptop","Total Harga Beli","Total Harga Jual","Total Keuntungan")
        System.out.format("|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
        for(i in 0 until transactionSellingList.count()){
            System.out.format("|   %23s   | %6d     | %7d      | %19s   | %19s   |  %17s  |\n",transactionSellingList[i].date, transactionSellingList[i].totalTipeYangDijual, transactionSellingList[i].totalLaptopYangDijual,transactionSellingList[i].totalHarga.toRupiah(),(transactionSellingList[i].totalHarga + transactionSellingList[i].totalKeuntungan).toRupiah(), transactionSellingList[i].totalKeuntungan.toRupiah())
        }
        System.out.format("|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
    }

    fun readBuyingTransaction(){
        println(" Transaksi Pembelian Laptop \n")
        System.out.format("|-----------------------------|------------|--------------|---------------------|\n")
        System.out.format("|   %15s           | %10s | %12s | %14s      |\n","Tanggal","Total Tipe","Total Laptop","Total Harga")
        System.out.format("|-----------------------------|------------|--------------|---------------------|\n")
        for(i in 0 until trasactionBuyingList.count()){
            System.out.format("|   %23s   | %6d     | %7d      | %17s   |\n",trasactionBuyingList[i].date, trasactionBuyingList[i].totalTipeYangDibeli, trasactionBuyingList[i].totalLaptopYangDibeli, trasactionBuyingList[i].totalHarga.toRupiah())
        }
        System.out.format("|-----------------------------|------------|--------------|---------------------|\n")
    }

    fun cancelBuyingTransaction(laptopRepository: LaptopRepository, financialReports: FinancialReports){
        var sign = true
        System.out.format("|----|-----------------------------|------------|--------------|---------------------|\n")
        System.out.format("| No |   %15s           | %10s | %12s | %14s      |\n","Tanggal","Total Tipe","Total Laptop","Total Harga")
        System.out.format("|----|-----------------------------|------------|--------------|---------------------|\n")
        for(i in 0 until trasactionBuyingList.count()){
            System.out.format("|%3d |   %23s   | %6d     | %7d      | %17s   |\n",i+1,trasactionBuyingList[i].date, trasactionBuyingList[i].totalTipeYangDibeli, trasactionBuyingList[i].totalLaptopYangDibeli, trasactionBuyingList[i].totalHarga.toRupiah())
        }
        System.out.format("|----|-----------------------------|------------|--------------|---------------------|\n")
        print("\nTransaksi Mana Yang Ingin Dibatalkan : ")
        var pilihan = readLine()?.toInt()?:0
        if(pilihan > trasactionBuyingList.count() || pilihan <= 0){
            sign = false
        }
        pilihan--
        var count = 0
        // jika sudah yakin dan pilihan ada di list
        if(isOK() && sign){
            val laptopList = laptopRepository.getLaptopList()
            val laptopListBackup = trasactionBuyingList[pilihan].laptopListBackup
            for (i in 0 until laptopList.count()) {
                    for(j in 0 until laptopListBackup.list.count())
                   // jika stok di laptoplist lebih dari stok pembelian serta merek dan tipenya sama
                    if(laptopList[i].stok >= laptopListBackup.list[j].stok &&
                            laptopList[i].merek == laptopListBackup.list[j].merek &&
                            laptopList[i].tipe == laptopListBackup.list[j].tipe){
                        count++
                    }
            }
            // jika count sama dengan jumlah tipe yang stoknya mencukupi
            if(count == laptopListBackup.list.count()){
                for (i in 0 until laptopList.count()) {
                    for(j in 0 until laptopListBackup.list.count())
                    if (laptopList[i].merek == laptopListBackup.list[j].merek &&
                            laptopList[i].tipe == laptopListBackup.list[j].tipe) {
                        laptopList[i].stok -= laptopListBackup.list[j].stok
                    }
                }

                laptopRepository.setLaptopList(laptopList)
                financialReports.setMoneyTotal(financialReports.getMoneyTotal() + trasactionBuyingList[pilihan].totalHarga)
                trasactionBuyingList.removeAt(pilihan)
                gsonTransactionBuyingList = gsonPresetableWrite.toJson(trasactionBuyingList)
                fileDataTransactionBuying.writeText(gsonTransactionBuyingList)
                println("\nBerhasil Dibatalkan !!!")
                financialReports.getMoneyTotalRp()
            }
            else{
                println("\nTidak bisa dibatalkan karena stok sudah berkurang")
            }
        }
        else{
            println("\nTidak Jadi Dibatalkan !!!")
        }
    }

    fun cancelSellingTransaction(laptopRepository: LaptopRepository, financialReports: FinancialReports){
        var sign = true
        System.out.format("|----|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
        System.out.format("| No |   %15s           | %10s | %12s | %19s   | %19s   |  %17s  |\n","Tanggal","Total Tipe","Total Laptop","Total Harga Beli","Total Harga Jual","Total Keuntungan")
        System.out.format("|----|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
        for(i in 0 until transactionSellingList.count()){
            System.out.format("|%3d |   %23s   | %6d     | %7d      | %19s   | %19s   |  %17s  |\n",i+1,transactionSellingList[i].date, transactionSellingList[i].totalTipeYangDijual, transactionSellingList[i].totalLaptopYangDijual, (transactionSellingList[i].totalHarga - transactionSellingList[i].totalKeuntungan).toRupiah(),transactionSellingList[i].totalHarga.toRupiah(), transactionSellingList[i].totalKeuntungan.toRupiah())
        }
        System.out.format("|----|-----------------------------|------------|--------------|-----------------------|-----------------------|---------------------|\n")
        print("\nTransaksi Mana Yang Ingin Dibatalkan : ")
        var pilihan = readLine()?.toInt()?:0
        if(pilihan > transactionSellingList.count() || pilihan <= 0){
            sign = false
        }
        pilihan--

        // jika sudah yakin dan pilihan ada di list dan total penjualan kurang dari sama dengan uang kas
        if(isOK() && sign && (transactionSellingList[pilihan].totalHarga + transactionSellingList[pilihan].totalKeuntungan) <= financialReports.getMoneyTotal() ){
            val laptopList = laptopRepository.getLaptopList()
            val laptopListBackup = transactionSellingList[pilihan].laptopListBackup
            val laptopListTrash = laptopRepository.getLaptopListTrash()

             loop@ for(i in 0 until laptopListBackup.list.count()) {
                for(j in 0 until laptopList.count()){
                  // jika data laptop yang dijual masih ada di laptop list
                  if(laptopListBackup.list[i].tipe== laptopList[j].tipe && laptopListBackup.list[i] .merek == laptopList[j].merek){
                      laptopList[j].stok += laptopListBackup.list[i] .stok
                      continue@loop
                  }
                }
                 for(l in 0 until laptopListTrash.count()){
                     // jika data laptop yang dijual ada di laptop list trash
                     if(laptopListTrash[l].tipe == laptopListBackup.list[i].tipe && laptopListTrash[l].merek == laptopListBackup.list[i].merek){
                         laptopList.add(laptopListTrash[l])
                         laptopListTrash.removeAt(l)
                         laptopList.last().stok = laptopListBackup.list[i].stok
                         laptopRepository.setLaptopListTrash(laptopListTrash)
                         continue@loop
                     }
              }
            }
            laptopRepository.setLaptopList(laptopList)
            financialReports.setMoneyTotal(financialReports.getMoneyTotal() - transactionSellingList[pilihan].totalHarga- transactionSellingList[pilihan].totalKeuntungan)
            transactionSellingList.removeAt(pilihan)
            gsonTransactionSellingList = gsonPresetableWrite.toJson(transactionSellingList)
            fileDataTransactionSelling.writeText(gsonTransactionSellingList)
            println("\nBerhasil Dibatalkan !!!")
            financialReports.getMoneyTotalRp()
        }
        else{
            println("\nTidak Jadi Dibatalkan !!!")
        }
    }
}