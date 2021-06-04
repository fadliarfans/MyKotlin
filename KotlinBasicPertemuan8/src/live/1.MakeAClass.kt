package live

class Fish{
    // properties
    var name = ""
    val weight = 0
    val long = 0

    // behaviours
    fun swim(){
        println("ikan $name berenang !")
    }
}

fun main(){
    //object
    val salmon = Fish()
    salmon.name = "Salmon"
    salmon.swim()

    //object
    val lele = Fish()
    lele.name = "lele"
    lele.swim()
}