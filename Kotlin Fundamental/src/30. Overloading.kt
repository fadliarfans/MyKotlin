fun main(){
    val sapi = Animal2()
    sapi.eat()
    sapi.eat("rumput")
    sapi.eat("rumput", "hutan")
}

class Animal2{
//  menggunakan dua atau lebih fungsi dengan nama yang sama disebut dengan overloading.

    fun eat(){
        println("makan")
    }

    fun eat(makanan:String){
        println("makan $makanan")
    }

    fun eat(makanan: String,tempat:String){
        println("makan $makanan di $tempat")
    }

}