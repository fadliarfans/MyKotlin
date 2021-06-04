package live

class Car(val name:String, val jumlahRoda:Int){
    fun ngerem(){
        println("Mobil berhenti")
    }
}

fun main(){
    val xenia = Car("Xenia",4)
    println("Jumlah roda mobil ${xenia.name} ada ${xenia.jumlahRoda}")
    xenia.ngerem()
}