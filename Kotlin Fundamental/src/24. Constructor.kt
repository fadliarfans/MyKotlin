fun main(){
    val segitiga = Segitiga(5,10)
    println("Luas Segitiga = ${segitiga.luas}")

    val trapesium = Trapesium(5,10,-7)
    println("Luas Trapesium = ${trapesium.luas1}")
    println("Luas Trapesium = ${trapesium.luas2}")
}


class Segitiga(alas:Int, tinggi:Int){   // primary constructor
    val luas = 0.5 * alas * tinggi      // properties
}

class Trapesium(alas1:Int, alas2:Int , tinggi: Int){  // primary constructor
    val alas1:Int    // properties
    val alas2:Int    // properties
    val tinggi:Int   // properties

    init {    // memvalidasi sebuah nilai properti sebelum diinisialisasi.
        this.alas1 = if(alas1<0) alas1*-1 else alas1
        this.alas2 = if(alas2<0) alas2*-1 else alas2
        this.tinggi = if(tinggi<0) tinggi*-1 else tinggi
    }

    val luas1 = (alas1 + alas2) * 0.5 * tinggi
    val luas2 = (this.alas1 + this.alas2) * 0.5 * this.tinggi
}

/*
blok init di sini memiliki beberapa fungsi selain menginisialisasi properti kelas.
satu fungsi lainnya adalah untuk membantu dalam
memvalidasi sebuah nilai properti sebelum diinisialisasi.
 */
