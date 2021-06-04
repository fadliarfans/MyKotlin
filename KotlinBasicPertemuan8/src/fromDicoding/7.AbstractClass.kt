package fromDicoding

abstract class Animal7(var name: String, var weight: Double, var age: Int, var isCarnivore: Boolean){

    fun eat(){
        println("$name sedang makan !")
    }

    fun sleep(){
        println("$name sedang tidur !")
    }
}

fun main(){
    // val animal7 = Animal7("dicoding animal", 2.6, 1, true) -> Will Error
}