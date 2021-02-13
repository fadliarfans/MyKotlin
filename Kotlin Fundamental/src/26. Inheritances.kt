fun main(){
    val persegiPanjang2 = PersegiPanjang2()
    persegiPanjang2.panjang = 20
    persegiPanjang2.lebar = 30

}

open class BangunDatar2{
    var panjang:Int = 0
    var lebar:Int = 0
}

class PersegiPanjang2:BangunDatar2()  // inheritances
