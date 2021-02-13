fun main(){
    val persegiPanjang = PersegiPanjang()  // deklarasi objek
    persegiPanjang.panjang = 10       // set
    persegiPanjang.lebar = 20         // set
    println("Luas Persegi panjang     : ${persegiPanjang.luas()}")  // get
    println("Keliling Persegi Panjang : ${persegiPanjang.keliling()}")  // get

}

class PersegiPanjang{        // class
    var panjang = 0          // properties
    var lebar = 0            // properties
    fun luas():Int{          // functions
        return panjang * lebar
    }
    fun keliling():Int = 2*(panjang+lebar) // functions
}

/*
Setiap kelas memiliki atribut dan behaviour.
Dalam Kotlin attributes lebih sering disebut dengan properties,
sedangkan behaviour sering disebut functions.

Class: Merupakan sebuah blueprint yang terdapat properti dan fungsi di dalamnya
Properties: Karakteristik dari sebuah kelas, memiliki tipe data.
Functions: Kemampuan atau aksi dari sebuah kelas.

*/


