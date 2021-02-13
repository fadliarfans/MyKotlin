fun main(){
  val persegiPanjang =  PersegiPanjang5()
    persegiPanjang.panjang = 10
    persegiPanjang.lebar = 40
    print(persegiPanjang.luas() )
}


class PersegiPanjang5:BangunDatar5{
    var panjang:Int = 0
    var lebar:Int = 0
    override fun luas():Int {
        return panjang * lebar
    }
}

interface BangunDatar5{
    fun luas():Int
}

/*
Interfaces merupakan suatu konsep sifat umum yang nantinya digunakan oleh suatu kelas agar dapat memiliki sifat tersebut.
Interface sangat mirip dengan abstract class, namun tanpa sebuah properti deklarasi dan fungsi yang dideklarasikan tanpa isi.
Tujuan dari interface ini hanya untuk diimplementasikan oleh sebuah kelas.
Kelas yang mengimplementasikan sebuah interface diharuskan melakukan override seluruh properti dan fungsi sekaligus mendefinisikan isi fungsi yang terdapat pada interfaces-nya.
 */
