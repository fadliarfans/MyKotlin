package fromDicoding

//class
class Animal(
    // property
    val name: String,
    val weight: Double,
    val age: Int,
    val isMammal: Boolean
) {
    // method atau function
    fun eat(){
        println("$name makan !")
    }
    // method atau function
    fun sleep() {
        println("$name tidur !")
    }
}

fun main() {
    // object
    val dicodingCat = Animal("Dicoding Miaw", 4.2, 2,true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )
    dicodingCat.eat()
    dicodingCat.sleep()
}

/*
Class      : Merupakan sebuah blueprint yang terdapat properti dan fungsi di dalamnya
Properties : Karakteristik dari sebuah kelas, memiliki tipe data.
Functions  : Kemampuan atau aksi dari sebuah kelas.
object     : realisasi dari sebuah blueprint
 */