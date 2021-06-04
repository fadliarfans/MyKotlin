package live

class Insect{
    var name = ""
    var wings = 0

    set(value){
        println("property di set dengan data terbaru")
        field = value
    }
    get(){
        println("getter dipanggil")
        return field
    }
}

fun main(){
    val capung = Insect()

    capung.name = "Capung"
    capung.wings = 2

    println("Sayap ${capung.name} ada ${capung.wings}")
}