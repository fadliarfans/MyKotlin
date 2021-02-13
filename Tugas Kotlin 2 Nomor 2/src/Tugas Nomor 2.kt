

class Cat(private val name:String){
    private var sleep:Boolean = false
    private fun toSleep(){
        if(sleep)
            println("$name, sleep!")
        else
            println("$name, let's play!")
    }

    fun getsleep() {
        println("Fungsi getter dipanggil")
        return toSleep()
    }
    fun setsleep(sleep:Boolean){
        println("Fungsi setter dipanggil")
        this.sleep = sleep
    }

}


fun main(){
    val gippy = Cat("Gippy")
    gippy.getsleep()
    gippy.setsleep(true)
    gippy.getsleep()
}


