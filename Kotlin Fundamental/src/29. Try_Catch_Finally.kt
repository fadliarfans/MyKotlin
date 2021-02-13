fun main(){

    val nullValue:String? = null
    lateinit var musttNotNull:String // lateinit berfungsi untuk memeperbolehkan inisialisasi property diluar constructor

    try{
        musttNotNull = nullValue!!
    }
    catch (e:Exception){
        musttNotNull = "nilainya null woi"
    }
    finally {
        println(musttNotNull)
    }
}



