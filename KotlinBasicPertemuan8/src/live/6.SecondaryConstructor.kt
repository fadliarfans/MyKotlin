package live

class Plane(name:String,jumlahSayap:Int){
    var name = ""
    var jumlahSayap = 0
    var jumlahMesin = 0

    init {
        this.name = name
        this.jumlahSayap = jumlahSayap
    }

    constructor(name:String,jumlahSayap:Int,jumlahMesin:Int):this(name,jumlahSayap){
        this.jumlahMesin = jumlahMesin
    }
}

fun main(){
    val cesna  = Plane("cesna",4)
    cesna.jumlahMesin = 2

    val boeing = Plane("cesna",4,2)
}