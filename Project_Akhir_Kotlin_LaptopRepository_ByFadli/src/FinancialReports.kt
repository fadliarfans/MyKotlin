import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.Exception
import java.text.DecimalFormat
import java.text.NumberFormat

class FinancialReports {
    private val gson = Gson()
    private val financialType = object : TypeToken<MutableList<Financial>>() {}.type!!    // untuk mendefinisikan tipe

    private var moneyTotal:MutableList<Financial> = gson.fromJson(FileReader("src/assets/DataFinancial.json"), financialType)    // untuk menguraikan json menjadi list
    private var wealthTotal = Financial()

    private var fileDataFinancial = File("src/assets/DataFinancial.json")          // deklarasi file

    private val gsonPresentableWrite = GsonBuilder().setPrettyPrinting().create()!!      // untuk mengubah list berisi objek menjadi json string yang mudah dibaca
    private var jsonMoneyTotal: String = gsonPresentableWrite.toJson(moneyTotal)

    private fun Long.toRupiah():String{
        val formatter: NumberFormat = DecimalFormat("#,###")
        val moneyRupiah = formatter.format(this)
        return "Rp $moneyRupiah"
    }

    fun getMoneyTotalRp(){
        try {
            println("\nTotal Uang Kas : ${moneyTotal[0].money.toRupiah()}")
        }catch (e:Exception){
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
        }
    }
    fun getWealthTotalRp(){
        println("\nTotal Kekayaan : ${wealthTotal.money.toRupiah()}")
    }

    fun getMoneyTotal():Long{
        var value:Long = 0
        try {
            value =  moneyTotal[0].money
        }catch (e:Exception){
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
        }
        return value
    }

    fun setMoneyTotal(value:Long){
        try {
            moneyTotal[0].money = value
        }catch (e:Exception){
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
        }
        jsonMoneyTotal = gsonPresentableWrite.toJson(moneyTotal)
        fileDataFinancial.writeText(jsonMoneyTotal)
    }
    fun setWealthTotal(laptopRepository: LaptopRepository) {
        try {
            wealthTotal.money =  laptopRepository.getAllPrice() + moneyTotal[0].money
        }catch (e:Exception){
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
            wealthTotal.money = laptopRepository.getAllPrice()
        }
    }

    fun plusMoneyTotal(){
        print("\nMasukan Uang Yang Ingin Ditambahkan : ")
        var sign = true
        val plus = readLine()?.toLong()?:0

        try {
            moneyTotal[0].money += plus
        }catch (e:Exception){
            sign = false
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
        }
        if(sign){
            println("\nUang Berhasil Ditambahkan !!! ")
        }
        else{
            println("\n Uang Tidak Berhasil Ditambahkan !!! ")
        }
        jsonMoneyTotal = gsonPresentableWrite.toJson(moneyTotal)
        fileDataFinancial.writeText(jsonMoneyTotal)
    }
    fun minusMoneyTotal(){
        print("\nMasukan Uang Yang Ingin Diambil     : ")
        val minus = readLine()?.toLong()?:0
        var sign = true
        try {
            moneyTotal[0].money -= minus
        }catch (e:Exception){
            sign = false
            println("\nMasalah : $e")
            println("\nDatafinansial.json belum ditambah objek money !!!!! ")
            val financial = Financial()
            moneyTotal.add(financial)
        }
        if(sign){
            println("\nUang Berhasil Diambil !!! ")
        }
        else{
            println("\n Uang Tidak Berhasil Diambil !!! ")
        }
        jsonMoneyTotal = gsonPresentableWrite.toJson(moneyTotal)
        fileDataFinancial.writeText(jsonMoneyTotal)
    }
}