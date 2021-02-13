import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LaptopRepository:ILaptopCRUD {
    private val gson = Gson()
    private val mutableListType = object : TypeToken<MutableList<Laptop>>() {}.type!!    // untuk mendefinisikan tipe

    private var laptopList: MutableList<Laptop> = gson.fromJson(FileReader("src/assets/DataLaptop.json"), mutableListType)    // untuk menguraikan json menjadi list
    private var laptopListTrash: MutableList<Laptop> = gson.fromJson(FileReader("src/assets/DataLaptopTrash.json"), mutableListType)
    private var laptopListTemporary = mutableListOf<Laptop>()
    private var laptopTemporary = LaptopTemporary()
    private var laptopListListTemporaryPrimary = mutableListOf<LaptopPrimaryList>()

    private var fileDataLaptop = File("src/assets/DataLaptop.json")             // deklarasi file
    private var fileDataLaptopTrash = File("src/assets/DataLaptopTrash.json")

    private val gsonPresentableWrite = GsonBuilder().setPrettyPrinting().create()!!      // untuk mengubah list berisi objek menjadi json string yang mudah dibaca
    private var jsonLaptopList: String = gsonPresentableWrite.toJson(laptopList)         // laptopList diubah menjadi json string
    private var jsonLaptopListTrash: String = gsonPresentableWrite.toJson(laptopListTrash)

    private fun time():String {return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}
    private fun Long.toRupiah():String{
        val formatter: NumberFormat = DecimalFormat("#,###")
        val moneyRupiah = formatter.format(this)
        return "Rp $moneyRupiah"
    }

    private var positif:(Int) -> (Int) = {value:Int -> value * -1}
    private fun input(value:Int, positif:(Int)-> Int):Int{
        var x = value
        if(x < 0){
            x = positif(x)
        }
        return x
    }
    private var positifLong:(Long) -> (Long) = { value:Long -> value * -1}
    private fun input(value:Long, positif:(Long)-> Long):Long{
        var x = value
        if(x < 0){
            x = positif(x)
        }
        return x
    }
    private fun isOK():Boolean{
        print("\nApakah Anda Sudah Yakin [Y/N] : ")
        var input = readLine()?:""
        input = input.toUpperCase()
        return  input == "Y"
    }
    private fun writeJsonLaptopList(){
        jsonLaptopList = gsonPresentableWrite.toJson(laptopList)
        fileDataLaptop.writeText(jsonLaptopList)        // untuk menulis ulang json sesuai dengan laptopList terbaru
    }
    override fun getAllPrice():Long{ // untuk mendapatkan harga semua laptop
        var totalHarga:Long = 0
        laptopList.forEach { totalHarga+= it.harga * it.stok }
        return totalHarga
    }

    override fun addLaptopNew(financialReports: FinancialReports, transactionReports: TrasactionReports){
        val laptopListTemporaryPrimary = LaptopPrimaryList()
        laptopListListTemporaryPrimary.add(laptopListTemporaryPrimary)
        var k = 0
        var sign:Boolean

        laptopTemporary.totalHarga = 0
        laptopTemporary.totalStok = 0

        print("\nBerapa Tipe Laptop Yang Ingin Ditambah : ")
        laptopTemporary.totalTipe = input(readLine()?.toInt()?:0, positif)
        while ( k < laptopTemporary.totalTipe) {
            sign = false

            //  jika user selalu menginputkan jenis laptop yang sama,  akan terus terulang
            while(!sign){
                sign = true
                println("\nLaptop Ke-${k+1}")
                print("Masukan Merek Laptop          : ")
                laptopTemporary.merek = readLine() ?: "NoName"
                print("Masukan Tipe Laptop           : ")
                laptopTemporary.tipe = readLine() ?: "NoName"

                // pengecekan di laptopList
                for(i in 0 until laptopList.count()){
                    //jika laptop yang baru diinput sama dengan laptopList
                    if(laptopList[i].merek == laptopTemporary.merek
                            && laptopList[i].tipe == laptopTemporary.tipe){
                        println("\nLaptop Tersebut Sudah Ada !!!, Masukan Kembali Laptop Dengan Benar")
                        sign = false
                        break
                    }
                }

                //pengecekan di laptopListTemporary
                for(i in 0 until laptopListTemporary.count()){
                    //jika laptop yang baru diinput sama dengan laptopListtemporary
                    if(laptopTemporary.merek == laptopListTemporary[i].merek &&
                            laptopTemporary.tipe == laptopListTemporary[i].tipe ){
                        println("\nLaptop Tersebut Sudah Ada !!!, Masukan Kembali Laptop Dengan Benar")
                        sign = false
                        break
                    }
                }
            }
            print("Masukan Tipe Processor Laptop : ")
            laptopTemporary.processor =  readLine() ?: "NoName"
            print("Masukan Ukuran Ram Laptop     : ")
            laptopTemporary.ram =  input(readLine()?.toInt()?:0, positif)
            print("Masukan Ukuran Rom Laptop     : ")
            laptopTemporary.rom =  input(readLine()?.toInt()?:0, positif)
            print("Tipe VGA Laptop               : ")
            laptopTemporary.vga =  readLine() ?: "NoName"
            print("Masukan Stok Laptop           : ")
            laptopTemporary.stok =  input(readLine()?.toInt()?:0, positif)
            print("Masukan Harga Laptop          : ")
            laptopTemporary.harga =  input(readLine()?.toLong()?:0, positifLong)
            println("Total Uang Anda               : ${financialReports.getMoneyTotal().toRupiah()}")
            println("Harga Total                   : ${(laptopTemporary.harga * laptopTemporary.stok).toRupiah()}")

            // jika harga total lebih dari uang kas
            if(laptopTemporary.harga * laptopTemporary.stok > financialReports.getMoneyTotal()){
                println("\nUangnya Kaga Cukup !!! ")
                continue
            }

            // jika pembelian sudah yakin
            if(isOK()){
                laptopListTemporary.add(Laptop(
                        laptopTemporary.merek,
                        laptopTemporary.tipe,
                        laptopTemporary.processor,
                        laptopTemporary.ram,
                        laptopTemporary.rom,
                        laptopTemporary.vga,
                        laptopTemporary.stok,
                        laptopTemporary.harga,
                        time()))
                k++
            }
            else{
                println("\nMasukan Ulang !")
            }
        }
        println("\nList Laptop Yang Anda Beli : ")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n","Merek","Tipe","Processor","Ram","Rom","Vga","Stok","Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        for(i in 0 until laptopTemporary.totalTipe){
            System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n",laptopListTemporary[i].merek,laptopListTemporary[i].tipe,laptopListTemporary[i].processor,laptopListTemporary[i].ram,laptopListTemporary[i].rom,laptopListTemporary[i].vga,laptopListTemporary[i].stok,laptopListTemporary[i].harga.toRupiah())
            laptopTemporary.totalHarga += laptopListTemporary[i].harga * laptopListTemporary[i].stok
            laptopTemporary.totalStok += laptopListTemporary[i].stok
        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        println("\nTotal Laptop   : ${laptopTemporary.totalStok}")
        println("Total Harga    : ${laptopTemporary.totalHarga}")
        financialReports.getMoneyTotalRp()

        // jika pembelian tidak yakin atau uang kas kurang dari total harga semua laptop
        if(!isOK() || financialReports.getMoneyTotal() < laptopTemporary.totalHarga){
            println("\n Pembelian Batal !!!! ")
        }
        else{
            for(i in 0 until laptopTemporary.totalTipe) {
                laptopList.add(Laptop(
                        laptopListTemporary[i].merek,
                        laptopListTemporary[i].tipe,
                        laptopListTemporary[i].processor,
                        laptopListTemporary[i].ram,
                        laptopListTemporary[i].rom,
                        laptopListTemporary[i].vga,
                        laptopListTemporary[i].stok,
                        laptopListTemporary[i].harga,
                        time()
                ))
                val laptopTemporaryPrimary = LaptopPrimary()
                laptopTemporaryPrimary.merek = (laptopListTemporary[i].merek)
                laptopTemporaryPrimary.tipe = (laptopListTemporary[i].tipe)
                laptopTemporaryPrimary.stok = (laptopListTemporary[i].stok)
                laptopListListTemporaryPrimary.last().list.add(laptopTemporaryPrimary)
            }
            writeJsonLaptopList()
            financialReports.setMoneyTotal(financialReports.getMoneyTotal() - laptopTemporary.totalHarga)
            financialReports.getMoneyTotalRp()
            transactionReports.addBuyingTransaction(time(), laptopTemporary.totalTipe, laptopTemporary.totalStok, laptopTemporary.totalHarga, laptopListListTemporaryPrimary.last())
        }
        laptopListTemporary.clear()
    }

    override fun addLaptopOld(financialReports: FinancialReports, transactionReports: TrasactionReports){
        val laptopListTemporaryPrimary = LaptopPrimaryList()
        laptopListListTemporaryPrimary.add(laptopListTemporaryPrimary)
        var stokLaptopYangDiTambah:Int
        var count:Int
        var k = 0
        var j = 0
        val merekList = mutableListOf<String>()
        val tipeMap = mutableMapOf(0 to "Default")


        print("\nBerapa Tipe Laptop Yang Ingin Ditambah : ")
        laptopTemporary.totalTipe = input(readLine()?.toInt()?:0, positif)
        laptopTemporary.totalStok = 0
        laptopTemporary.totalHarga = 0
        while( k < laptopTemporary.totalTipe) {
            var sign = true
            count = 1
            laptopList.forEach {
                // jika di dalam merekList blom ada merek yang seperti di laptopList
                if(!merekList.contains(it.merek))
                     merekList.add(it.merek)
                }

            println("\nLaptop Ke-${k+1}")
            println("|------|------------------|")
            println("|  No  |      Merek       |")
            println("|------|------------------|")
            merekList.forEach { System.out.format("|%4d  |   %-15s|\n",++j, it) }
            println("|------|------------------|")
            j = 0

            print("Merek Laptop Yang Ke          : ")
            var pilihan = readLine()?.toInt()?:0

            // jika pilihan lebih dari total merekList atau kurang dari sama dengan 0
            if(pilihan > merekList.count() || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            pilihan--
            laptopTemporary.merek = merekList[pilihan]

            println("|------|------------------|")
            println("|  No  |       Tipe       |")
            println("|------|------------------|")
            laptopList.forEach {
                // jika merek laptop temporary sama dengan merek yand ada di laptopList
                if(laptopTemporary.merek == it.merek){
                    System.out.format("|%4d  |   %-15s|\n",count,it.tipe)
                    tipeMap[count] = it.tipe
                    count++
                }
            }
            println("|------|------------------|")

            print("Tipe Laptop Yang Ke           : ")
            pilihan = readLine()?.toInt()?:0

            // jika pilihan lebih dari total tipeMap atau kurang dari sama dengan 0
            if(pilihan > tipeMap.count()-1 || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            laptopTemporary.tipe = tipeMap[pilihan]?:""

            laptopList.forEach {
                // jika merek dan tipe laptop temporary sama dengan merek dan tipe yand ada di laptopList
                if (it.merek == laptopTemporary.merek
                        && it.tipe == laptopTemporary.tipe) {
                    financialReports.getMoneyTotalRp()
                    println("Harga Laptop                               : ${it.harga.toRupiah()}")
                    print("Masukan Jumlah Stok Yang Ingin Ditambahkan : ")
                    stokLaptopYangDiTambah = input(readLine()?.toInt()?:0, positif)
                    println("Harga Total                                : ${(it.harga * stokLaptopYangDiTambah).toRupiah()}")

                    // jika pembelian sudah yakin dan total uang kas lebih dai total harga
                    if(isOK() && financialReports.getMoneyTotal() > it.harga * stokLaptopYangDiTambah){
                        it.stok += stokLaptopYangDiTambah                                // stok di laptop list ditambah sesuai tipe yang ditambah
                        laptopTemporary.totalStok += stokLaptopYangDiTambah              // total stok yang ditambah dari seluruh tipe
                        laptopTemporary.totalHarga += it.harga * stokLaptopYangDiTambah  // total harga dari seluruh tipe
                        val laptopTemporaryPrimary = LaptopPrimary()
                        laptopTemporaryPrimary.merek = it.merek
                        laptopTemporaryPrimary.tipe = it.tipe
                        laptopTemporaryPrimary.stok = stokLaptopYangDiTambah
                        laptopListListTemporaryPrimary.last().list.add(laptopTemporaryPrimary)
                    }else {
                        sign = false
                    }
                }
            }
            // jika pembelian tidak yakin atu total uang kas kurang dai total harga
            if(!sign){
                println("\n Laptop Tidak Berhasil Ditambahkan !!! ")
                continue
            }
            println("\nLaptop Berhasil Ditambah")
            k++
            writeJsonLaptopList()
        }
        financialReports.setMoneyTotal(financialReports.getMoneyTotal() - laptopTemporary.totalHarga)
        financialReports.getMoneyTotalRp()
        transactionReports.addBuyingTransaction(time(), laptopTemporary.totalTipe, laptopTemporary.totalStok, laptopTemporary.totalHarga, laptopListTemporaryPrimary)
    }

    override fun sellLaptop(financialReports: FinancialReports, transactionReports: TrasactionReports){
        val laptopListTemporaryPrimary = LaptopPrimaryList()
        laptopListListTemporaryPrimary.add(laptopListTemporaryPrimary)
        var count:Int
        var k = 0
        var sign:Boolean

        val keuntungan = mutableListOf<Int>()
        val hargaSetelahDitambahKeuntungan = mutableListOf<Long>()
        var totalHargaSetelahDitambahKeuntungan:Long = 0
        val merekList = mutableListOf<String>()
        val tipeMap = mutableMapOf(0 to "Default")

        laptopTemporary.totalHarga = 0
        laptopTemporary.totalStok = 0
        laptopTemporary.totalTipe = 0
        laptopTemporary.totalKeuntungan = 0

        print("\nBerapa Tipe Yang Akan Dijual : ")
        laptopTemporary.totalTipe = input(readLine()?.toInt()?:0, positif)

        while(k < laptopTemporary.totalTipe){
            count = 1
            sign = true

            for(i in 0 until laptopList.count()){
                // jika di dalam merekList blom ada merek yang seperti di laptopList
                if(!merekList.contains(laptopList[i].merek)) {
                    merekList.add(laptopList[i].merek)
                }
            }

            println("\nLaptop Ke-${k+1}")
            println("|------|------------------|")
            println("|  No  |      Merek       |")
            println("|------|------------------|")
            for(i in 0 until merekList.count()){
                System.out.format("|%4d  |   %-15s|\n",i+1, merekList[i])
            }
            println("|------|------------------|")

            print("Merek Laptop Yang Ke          : ")
            var pilihan = readLine()?.toInt()?:0

            // jika pilihan lebih dari total merekList atau kurang dari sama dengan 0
            if(pilihan > merekList.count() || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            pilihan--
            laptopTemporary.merek = merekList[pilihan]

            println("|------|------------------|")
            println("|  No  |       Tipe       |")
            println("|------|------------------|")
            for(i in 0 until laptopList.count()){
                if(laptopTemporary.merek == laptopList[i].merek){
                    System.out.format("|%4d  |   %-15s|\n",count,laptopList[i].tipe)
                    tipeMap[count] = laptopList[i].tipe  // dari satu agar sama dengan tablenya
                    count++
                }
            }
            println("|------|------------------|")

            print("Tipe Laptop Yang Ke                : ")
            pilihan = readLine()?.toInt()?:0

            // jika pilihan lebih dari total tipeMap atau kurang dari sama dengan 0
            if(pilihan > tipeMap.count()-1 || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            laptopTemporary.tipe = tipeMap[pilihan]?:""

            for(j in 0 until laptopListTemporary.count()){
                //jika laptop yang baru diinput sama dengan laptopListtemporary
                if(laptopListTemporary[j].merek == laptopTemporary.merek && laptopTemporary.tipe == laptopListTemporary[j].tipe){
                    println("\nLaptop Tersebut Sudah Diinputkan !!!, Masukan Kembali Laptop Dengan Benar")
                    sign = false
                    break
                }
            }
            // jika laptop yang baru diinputkan sama seperti sebelumnya
            if(!sign){
                continue
            }

            // untuk mendapatkan harga dari membandingakan merek dan tipe temporary dengan merek dan tipe yang ada di laptopList
            for(j in 0 until laptopList.count()){
                if( laptopTemporary.merek == laptopList[j].merek &&
                        laptopTemporary.tipe == laptopList[j].tipe){
                    laptopTemporary.harga = laptopList[j].harga
                    println("Harga Laptop                       : ${laptopTemporary.harga.toRupiah()}")
                    break
                }
            }

            print("Masukan Keuntungan (Rp)            : ")
            keuntungan.add(input(readLine()?.toInt()?:0, positif))
            print("Masukan Jumlah Laptop Yang Dijual  : ")
            laptopTemporary.stok = input(readLine()?.toInt()?:0, positif)

            //  untuk mengetahui apakah stok mencukupi
            for(j in 0 until laptopList.count()){
                if(laptopTemporary.merek == laptopList[j].merek &&
                        laptopTemporary.tipe == laptopList[j].tipe &&
                        laptopTemporary.stok > laptopList[j].stok){
                    sign = false
                    break
                }
            }

            // jika stok tidak mencukupi
            if(!sign){
                keuntungan.removeLast()
                merekList.removeLast()
                println("\nStok Tidak Mencukupi !!!")
                continue
            }
            // jika sudah yakin dengan penjualan
            if(isOK()){
                laptopListTemporary.add(Laptop(
                        laptopTemporary.merek,
                        laptopTemporary.tipe,
                        laptopTemporary.processor,
                        laptopTemporary.ram,
                        laptopTemporary.rom,
                        laptopTemporary.vga,
                        laptopTemporary.stok,
                        laptopTemporary.harga,
                        time()))
                k++
            }
            else{
                continue
            }
        }
        for(i in 0 until laptopTemporary.totalTipe){
            hargaSetelahDitambahKeuntungan.add(laptopListTemporary[i].harga + keuntungan[i].toLong())
            println("""
                                
            Laptop Ke-${i+1}
            Merek Yang  Dijual : ${laptopListTemporary[i].merek}
            Tipe Yang   Dijual : ${laptopListTemporary[i].tipe}
            Harga Asli         : ${laptopListTemporary[i].harga.toRupiah()}
            Harga Yang  Dijual : ${hargaSetelahDitambahKeuntungan[i].toRupiah()}
            Jumlah Yang Dijual : ${laptopListTemporary[i].stok}
            Total Harga        : ${(hargaSetelahDitambahKeuntungan[i] * laptopListTemporary[i].stok).toRupiah()}         
            """.trimIndent())
            val laptopTemporaryPrimary = LaptopPrimary()
            laptopTemporaryPrimary.merek = laptopListTemporary[i].merek
            laptopTemporaryPrimary.tipe = laptopListTemporary[i].tipe
            laptopTemporaryPrimary.stok = laptopListTemporary[i].stok
            laptopListListTemporaryPrimary.last().list.add(laptopTemporaryPrimary)

            laptopTemporary.totalStok += laptopListTemporary[i].stok
            laptopTemporary.totalKeuntungan += keuntungan[i] * laptopListTemporary[i].stok
            laptopTemporary.totalHarga +=laptopListTemporary[i].harga * laptopListTemporary[i].stok
            totalHargaSetelahDitambahKeuntungan += hargaSetelahDitambahKeuntungan[i] * laptopListTemporary[i].stok
        }

        fun kurangiStok(){
            for(i in 0 until laptopTemporary.totalTipe){
                for(j in 0 until laptopList.count()){
                    if(laptopListTemporary[i].merek == laptopList[j].merek
                        && laptopListTemporary[i].tipe == laptopList[j].tipe && laptopListTemporary[i].stok <= laptopList[j].stok){
                    laptopList[j].stok -= laptopListTemporary[i].stok
                }
                }
            }
            println("\nLaptop Anda Berhasil Terjual !!")
            transactionReports.addSellingTransaction(time(), laptopTemporary.totalTipe, laptopTemporary.totalStok, laptopTemporary.totalHarga , laptopTemporary.totalKeuntungan, laptopListTemporaryPrimary)
            financialReports.setMoneyTotal(financialReports.getMoneyTotal() + totalHargaSetelahDitambahKeuntungan)
            writeJsonLaptopList()
        }

        println("\nTotal Harga Semua Laptop             : ${totalHargaSetelahDitambahKeuntungan.toRupiah()}")

        if(isOK()){
            kurangiStok()
        }
        else{
            println("\nLaptop Anda Tidak Berhasil Terjual")
        }
        laptopListTemporary.clear()
        keuntungan.clear()
        hargaSetelahDitambahKeuntungan.clear()
        merekList.clear()
    }

    override fun sellLaptopAll(financialReports: FinancialReports, transactionReports: TrasactionReports){
        val laptopListTemporaryPrimary = LaptopPrimaryList()
        laptopListListTemporaryPrimary.add(laptopListTemporaryPrimary)
        laptopTemporary.totalStok = 0
        laptopTemporary.totalTipe = 0
        laptopTemporary.totalKeuntungan = 0

        print("Masukan Keuntungan (Rp)            : ")
        laptopTemporary.totalKeuntungan = input(readLine()?.toLong()?:0, positifLong)

        for(i in 0 until laptopList.count()){
            laptopTemporary.totalStok+= laptopList[i].stok
        }

        laptopTemporary.totalTipe = laptopList.count()
        laptopTemporary.totalKeuntungan *= laptopTemporary.totalStok
        laptopTemporary.totalHarga = getAllPrice()
        val hargaSetelahDitambahKeuntungan = laptopTemporary.totalHarga + laptopTemporary.totalKeuntungan
        println("""
            
            Total Tipe Semua Laptop   : ${laptopTemporary.totalTipe}
            Total Jumlah Semua Laptop : ${laptopTemporary.totalStok}
            Total Harga Beli Laptop   : ${laptopTemporary.totalHarga.toRupiah()}
            Total Harga Jual Laptop   : ${hargaSetelahDitambahKeuntungan.toRupiah()}
           
        """.trimIndent())
        if(isOK()){
            for(i in 0 until laptopList.count()){
                val laptopTemporaryPrimary = LaptopPrimary()
                laptopTemporaryPrimary.merek = laptopList[i].merek
                laptopTemporaryPrimary.tipe = laptopList[i].tipe
                laptopTemporaryPrimary.stok = laptopList[i].stok
                laptopListListTemporaryPrimary.last().list.add(laptopTemporaryPrimary)
                laptopList[i].stok = 0
            }
            transactionReports.addSellingTransaction(time(), laptopTemporary.totalTipe, laptopTemporary.totalStok,laptopTemporary.totalHarga, laptopTemporary.totalKeuntungan, laptopListTemporaryPrimary)
            writeJsonLaptopList()
            println("\nSemua Laptop Anda Berhasil Terjual !!! ")
            financialReports.setMoneyTotal(financialReports.getMoneyTotal() + hargaSetelahDitambahKeuntungan)
            financialReports.getMoneyTotalRp()
        }
        else {println("\nSemua Laptop Anda Tidak Berhasil Terjual !!! ")
        }
    }

    override fun lookLaptopAll(){
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n","Merek","Tipe","Processor","Ram","Rom","Vga","Stok","Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

        for(i in 0 until laptopList.count()){
            System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n",laptopList[i].merek,laptopList[i].tipe,laptopList[i].processor,laptopList[i].ram,laptopList[i].rom,laptopList[i].vga,laptopList[i].stok,laptopList[i].harga.toRupiah())
        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

    }

    override fun lookLaptopBrand() {
        print("\nMasukan Merek Laptop : ")
        laptopTemporary.merek = readLine() ?: ""

        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n","Merek","Tipe","Processor","Ram","Rom","Vga","Stok","Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

        for(i in 0 until laptopList.count()){
            if(laptopList[i].merek == laptopTemporary.merek)
            System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n",laptopList[i].merek,laptopList[i].tipe,laptopList[i].processor,laptopList[i].ram,laptopList[i].rom,laptopList[i].vga,laptopList[i].stok,laptopList[i].harga.toRupiah())
        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
    }

    override fun lookLaptopRam() {
        println("""
            
            Ingin Seperti Apa :
            1. Sama Dengan
            2. Kurang Dari
            3. Lebih Dari
            
        """.trimIndent())
        print("input : ")
        val pilihan = readLine()?.toInt() ?: 0
        print("Batasan : ")
        val batasan = readLine()?.toInt() ?: 0
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n", "Merek", "Tipe", "Processor", "Ram", "Rom", "Vga", "Stok", "Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

        for (i in 0 until laptopList.count()) {
            when (pilihan) {
                1 -> {
                    if (laptopList[i].ram == batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                2 -> {
                    if (laptopList[i].ram < batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                3 -> {
                    if (laptopList[i].ram > batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
            }

        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
    }

    override fun lookLaptopRom() {
        println("""
            
            Ingin Seperti Apa :
            1. Sama Dengan
            2. Kurang Dari
            3. Lebih Dari
            
        """.trimIndent())
        print("input : ")
        val pilihan = readLine()?.toInt() ?: 0
        print("Batasan : ")
        val batasan = readLine()?.toInt() ?: 0
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n", "Merek", "Tipe", "Processor", "Ram", "Rom", "Vga", "Stok", "Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

        for (i in 0 until laptopList.count()) {
            when (pilihan) {
                1 -> {
                    if (laptopList[i].rom == batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                2 -> {
                    if (laptopList[i].rom < batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                3 -> {
                    if (laptopList[i].rom > batasan)
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
            }

        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
    }

    override fun lookLaptopPrice() {
        println("""
            
            Ingin Seperti Apa :
            1. Sama Dengan
            2. Kurang Dari
            3. Lebih Dari
            
        """.trimIndent())
        print("input : ")
        val pilihan = readLine()?.toInt() ?: 0
        print("Batasan : ")
        val batasan = readLine()?.toInt() ?: 0
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
        System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n", "Merek", "Tipe", "Processor", "Ram", "Rom", "Vga", "Stok", "Harga")
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

        for (i in 0 until laptopList.count()) {
            when (pilihan) {
                1 -> {
                    if (laptopList[i].harga == batasan.toLong())
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                2 -> {
                    if (laptopList[i].harga < batasan.toLong())
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
                3 -> {
                    if (laptopList[i].harga > batasan.toLong())
                        System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n", laptopList[i].merek, laptopList[i].tipe, laptopList[i].processor, laptopList[i].ram, laptopList[i].rom, laptopList[i].vga, laptopList[i].stok, laptopList[i].harga.toRupiah())
                }
            }

        }
        System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
    }

    override fun updateLaptop(){
        val merekList = mutableListOf<String>()
        val tipeMap = mutableMapOf(0 to "Default")
        var count:Int
        var k = 0
        var index = 0
        print("\nMasukan Berapa Laptop Yang Ingin Diupdate : ")
        val banyakDiupdate = input(readLine()?.toInt()?:0, positif)

        while(k < banyakDiupdate){
            laptopTemporary.totalStok = 0
            laptopTemporary.totalHarga = 0
            count = 1
            for(i in 0 until laptopList.count()){
                // jika di dalam merekList blom ada merek yang seperti di laptopList
                if(!merekList.contains(laptopList[i].merek)) {
                    merekList.add(laptopList[i].merek)
                }
            }

            println("\nLaptop Ke-${k+1}")
            println("|------|------------------|")
            println("|  No  |      Merek       |")
            println("|------|------------------|")
            for(i in 0 until merekList.count()){
                System.out.format("|%4d  |   %-15s|\n",i+1, merekList[i])
            }
            println("|------|------------------|")

            print("Merek Laptop Yang Ke          : ")
            var pilihan = readLine()?.toInt()?:0

            // jika pilihan tidak ada di list
            if(pilihan > merekList.count() || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            pilihan--
            laptopTemporary.merek = merekList[pilihan]

            println("|------|------------------|")
            println("|  No  |       Tipe       |")
            println("|------|------------------|")
            for(i in 0 until laptopList.count()){
                if(laptopTemporary.merek == laptopList[i].merek){
                    System.out.format("|%4d  |   %-15s|\n",count,laptopList[i].tipe)
                    tipeMap[count] = laptopList[i].tipe
                    count++
                }
            }
            println("|------|------------------|")

            print("Tipe Laptop Yang Ke                        : ")
            pilihan = readLine()?.toInt()?:0      // karena menggunakan map jadi tidak dikurang satu

            // jika pilihan tidak ada di Map
            if(pilihan > tipeMap.count()-1 || pilihan <= 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            laptopTemporary.tipe = tipeMap[pilihan]?:""

            for(j in 0 until laptopList.count()){
                if(laptopTemporary.tipe == laptopList[j].tipe && laptopTemporary.merek == laptopList[j].merek){
                    index = j
                    break
                }
            }

            println("\nJika Tidak Ingin Diganti, Ketik '-' ")
            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
            System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n","Merek","Tipe","Processor","Ram","Rom","Vga","Stok","Harga")
            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
            System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n",laptopList[index].merek,laptopList[index].tipe,laptopList[index].processor,laptopList[index].ram,laptopList[index].rom,laptopList[index].vga,laptopList[index].stok,laptopList[index].harga.toRupiah())
            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

            print("\nmasukan processor : ")
                laptopTemporary.processor = readLine()?:""
                if(laptopTemporary.processor != "-"){
                    laptopList[index].processor = laptopTemporary.processor
                }
                print("masukan Ram       : ")
                laptopTemporary.ramString = readLine()?:""
                if(laptopTemporary.ramString != "-"){
                    laptopList[index].ram = laptopTemporary.ramString.toInt()
                }
                print("masukan Rom       : ")
                laptopTemporary.romString = readLine()?:""
                if(laptopTemporary.romString != "-"){
                    laptopList[index].rom = laptopTemporary.romString.toInt()
                }
                print("masukan Vga       : ")
                laptopTemporary.vga = readLine()?:""
                if(laptopTemporary.vga != "-"){
                    laptopList[index].vga = laptopTemporary.vga
                }
            if(isOK()){
                println("\nLaptop Sudah Diupdate !!!")
                k++
                writeJsonLaptopList()
            }
            else{
                println("\n Masukkan Ulang !!!" )
            }
        }
    }

    override fun removeLaptop(){
        var index = 0
        var k = 0
        val merekList = mutableListOf<String>()
        val tipeMap = mutableMapOf(0 to "Default")
        var count:Int

        print("\nMasukan Berapa Laptop Yang Ingin Dibuang : ")
        val yangInginDibuang = input(readLine()?.toInt()?:0, positif)

        while (k < yangInginDibuang) {
            merekList.clear()
            laptopTemporary.totalStok = 0
            laptopTemporary.totalHarga = 0
            count = 1
            for(i in 0 until laptopList.count()){
                // jika di dalam merekList blom ada merek yang seperti di laptopList
                if(!merekList.contains(laptopList[i].merek)) {
                    merekList.add(laptopList[i].merek)
                }
            }

            println("\nLaptop Ke-${k+1}")
            println("|------|------------------|")
            println("|  No  |      Merek       |")
            println("|------|------------------|")
            for(i in 0 until merekList.count()){
                System.out.format("|%4d  |   %-15s|\n",i+1, merekList[i])
            }
            println("|------|------------------|")

            print("Merek Laptop Yang Ke          : ")
            var pilihan = readLine()?.toInt()?:0

            // jika pilihan tidak ada di list
            if(pilihan > merekList.count() || pilihan < 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            pilihan--
            laptopTemporary.merek = merekList[pilihan]

            println("|------|------------------|")
            println("|  No  |       Tipe       |")
            println("|------|------------------|")
            for(i in 0 until laptopList.count()){
                if(laptopTemporary.merek == laptopList[i].merek){
                    System.out.format("|%4d  |   %-15s|\n",count,laptopList[i].tipe)
                    tipeMap[count] = laptopList[i].tipe
                    count++
                }
            }
            println("|------|------------------|")

            print("Tipe Laptop Yang Ke                        : ")
            pilihan = readLine()?.toInt()?:0      // karena menggunakan map jadi tidak dikurang satu

            // jika pilihan tidak ada di map
            if(pilihan > tipeMap.count()-1 || pilihan < 0){
                println("\nTidak Ada Di Pilihan !!!")
                continue
            }
            laptopTemporary.tipe = tipeMap[pilihan]?:""

            for (i in 0 until laptopList.count()) {
                if (laptopTemporary.merek == laptopList[i].merek && laptopTemporary.tipe == laptopList[i].tipe) {
                    index = i
                    break
                }
            }

            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
            System.out.format("|   %-9s|      %-12s|          %-22s |    %-6s|    %-5s |                %-5s               |  %-5s |      %-8s     |\n","Merek","Tipe","Processor","Ram","Rom","Vga","Stok","Harga")
            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")
            System.out.format("|   %-9s|   %-15s|  %-29s  |%4d GB   |%6d GB |  %-32s  |%6d  |  %15s  |\n",laptopList[index].merek,laptopList[index].tipe,laptopList[index].processor,laptopList[index].ram,laptopList[index].rom,laptopList[index].vga,laptopList[index].stok,laptopList[index].harga.toRupiah())
            System.out.format("|------------|------------------|---------------------------------|----------|----------|------------------------------------|--------|-------------------|\n")

            // jika sudah yakin
            if(isOK()) {
                laptopListTrash.add(laptopList[index])
                jsonLaptopListTrash = gsonPresentableWrite.toJson(laptopListTrash)
                fileDataLaptopTrash.writeText(jsonLaptopListTrash)
                laptopList.removeAt(index)
                jsonLaptopList = gsonPresentableWrite.toJson(laptopList)
                fileDataLaptop.writeText(jsonLaptopList)
                println("\nLaptop Berhasil DiBuang !!!")
                k++
            }
            else{
                println("\nLaptop Tidak Jadi Dibuang !!!")
            }
        }
    }

    override fun sortLaptopPrice(){
        var tmp:Laptop
        println("""
            
            Mengurutkan Laptop Berdasarkan Harga
            
            1. Dari Yang Termahal
            2. Dari Yang Termurah
            
        """.trimIndent())
        print("input : ")
        when(readLine()?.toInt()?:0) {
            1 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].harga < laptopList[j].harga) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
            2 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].harga > laptopList[j].harga) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
        }
        writeJsonLaptopList()
        println("Laptop Berhasil Diurutkan !!!")
    }

    override fun sortLaptopRam(){
        var tmp:Laptop
        println("""
            
            Mengurutkan Laptop Berdasarkan Ram
            
            1. Dari Yang Tertinggi
            2. Dari Yang Terendah
            
        """.trimIndent())
        print("input : ")
        when(readLine()?.toInt()?:0) {
            1 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].ram < laptopList[j].ram) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
            2 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].ram > laptopList[j].ram) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
        }
        writeJsonLaptopList()
        println("Laptop Berhasil Diurutkan !!!")
    }

    override fun sortLaptopRom(){
        var tmp:Laptop
        println("""
            
            Mengurutkan Laptop Berdasarkan Rom
            
            1. Dari Yang Tertinggi
            2. Dari Yang Terendah
            
        """.trimIndent())
        print("input : ")
        when(readLine()?.toInt()?:0) {
            1 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].rom < laptopList[j].rom) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
            2 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].rom > laptopList[j].rom) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
        }
        writeJsonLaptopList()
        println("Laptop Berhasil Diurutkan !!!")
    }

    override fun sortLaptopBrand(){
        var tmp:Laptop
        println("""
            
            Mengurutkan Laptop Berdasarkan Brand
            
            1. Ascending
            2. Descending
            
        """.trimIndent())
        print("input : ")
        when(readLine()?.toInt()?:0) {
            1 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].merek > laptopList[j].merek) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
            2 -> {
                for (i in 0 until laptopList.count() - 1) {
                    for (j in i + 1 until laptopList.count()) {
                        if (laptopList[i].merek < laptopList[j].merek) {
                            tmp = laptopList[i]
                            laptopList[i] = laptopList[j]
                            laptopList[j] = tmp
                        }

                    }

                }
            }
        }
        writeJsonLaptopList()
        println("Laptop Berhasil Diurutkan !!!")
    }

    override fun getLaptopList():MutableList<Laptop>{
        return laptopList
    }

    override fun setLaptopList(newLaptopList:MutableList<Laptop>){
        laptopList = newLaptopList
        jsonLaptopList = gsonPresentableWrite.toJson(laptopList)
        fileDataLaptop.writeText(jsonLaptopList)
    }

    override fun getLaptopListTrash():MutableList<Laptop>{
        return laptopListTrash
    }

    override fun setLaptopListTrash(newLaptopList:MutableList<Laptop>){
        laptopListTrash = newLaptopList
        jsonLaptopListTrash = gsonPresentableWrite.toJson(laptopListTrash)
        fileDataLaptopTrash.writeText(jsonLaptopListTrash)
    }
}