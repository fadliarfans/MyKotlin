import java.util.*

fun main(){
    val input = Scanner(System.`in`)
    var i = 1
    var count = 0
    var count2 = 0
    val struk = Struk2()
    while(i>0){
        val barang2 = Barang2()
        print("Masukan nama barang   : ")
        barang2.nm = readLine()
        print("Masukan harga barang  : ")
        barang2.hrg = input.nextInt()
        print("Masukan jumlah barang : ")
        barang2.jml = input.nextInt()
        struk.addlist(barang2)
        print("Ketik 1 untuk lanjut, ketik 0 jika sudah selesai : ")
        i = input.nextInt()
        println()
        count++
    }
    println("---- struk belanja ----")
    for(j in 0 until count){
        println("${struk.listbrg[j].nm} --> ${struk.listbrg[j].hrg}  X${struk.listbrg[j].jml} => ${struk.listbrg[j].hrg * struk.listbrg[j].jml}")
        count2+=struk.listbrg[j].hrg * struk.listbrg[j].jml
    }
    println("")
    println("Total harga = $count2")
}

class Barang2{
     var nm:String? = "default"
     var hrg = 0
     var jml = 0
}

class Struk2{
    var listbrg = mutableListOf<Barang2>()
    fun addlist(i: Barang2){listbrg.add(i) }
}