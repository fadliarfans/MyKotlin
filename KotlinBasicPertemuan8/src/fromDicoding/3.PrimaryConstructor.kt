package fromDicoding

class Animal3(var name: String, var weight: Double, var age: Int = 0, var isMammal: Boolean = true)

fun main(){
    val dicodingCat = Animal3("Dicoding Miaw", 4.2)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )
}