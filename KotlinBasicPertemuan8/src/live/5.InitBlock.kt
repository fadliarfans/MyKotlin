package live

class Motor(name:String,ccMesin:Int){
    var name = ""
    var ccMesin = 0

    init {
        this.name = name
        if(ccMesin < 0){
            println("CC mesin gak boleh negatif")
            this.ccMesin = 100
        }else{
            this.ccMesin = ccMesin
        }
    }

}

fun main(){
    val mio = Motor("Mio",125)
    val vario = Motor("Vario",-20)
}