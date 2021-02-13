import java.util.*

fun main(){
    val input = Scanner(System.`in`)
    var i = 1
    var count = 0
    var count2 = 0
    val struk = Struk()
    while(i>0){
        val barang = Barang()
        print("Masukan nama barang   : ")
        readLine()?.let { barang.setnm(it) }
        print("Masukan harga barang  : ")
        barang.sethrg(input.nextInt())
        print("Masukan jumlah barang : ")
        barang.setjml(input.nextInt())
        struk.addlist(barang)
        print("Ketik 1 untuk lanjut, ketik 0 jika sudah selesai : ")
        i = input.nextInt()
        println()
        count++
    }
    println("-- struk belanja --")
    for(j in 0 until count){
        println("${struk.getnm(j)} --> ${struk.gethrg(j)}  X${struk.getjml(j)} => ${struk.getjmlhrg(j)}")
        count2+=struk.getjmlhrg(j)
    }
    println("")
    println("Total harga = $count2")
}

class Barang{
    private var nm:String? = "default"
    private var hrg = 0
    private var jml = 0
    fun setnm(nm:String){ this.nm  = nm  }
    fun sethrg(hrg:Int) { this.hrg = hrg }
    fun setjml(jml:Int) { this.jml = jml }
    fun getnm() : String? = nm
    fun gethrg() : Int   = hrg
    fun getjml() : Int   = jml
}

class Struk{
    private var listbrg = mutableListOf<Barang>()
    fun addlist(i:Barang){ listbrg.add(i) }
    fun getnm(i:Int): String? = listbrg[i].getnm()
    fun gethrg(i:Int): Int = listbrg[i].gethrg()
    fun getjml(i:Int): Int = listbrg[i].getjml()
    fun getjmlhrg(i:Int): Int = listbrg[i].getjml() * listbrg[i].gethrg()
}