fun main(){
    val persegiPanjang3 = PersegiPanjang3()
    persegiPanjang3.panjang = 10
    persegiPanjang3.lebar = 30
    println(persegiPanjang3.luas())
}


abstract class BangunDatar3{
    var panjang:Int = 0
    var lebar:Int = 0
    open fun luas():Int = 0
}

class PersegiPanjang3:BangunDatar3(){
    override fun luas(): Int {
        return panjang*lebar
    }
}