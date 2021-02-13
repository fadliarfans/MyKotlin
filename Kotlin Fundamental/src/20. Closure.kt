fun main(){

    var a = 0
    val tambaha:() -> Unit = {
        a++
        println(" A telah ditambah ")
        println("A = $a")
    }
    tambaha()
    tambaha()
    tambaha()

}

/*
 - Closure adalah kemampuan sebuah function, lambda atau anonymous function berinteraksi
  dengan data-data disekitarnya dalam scope yang sama
 - Harap gunakan fitur closure ini dengan bijak saat kita membuat aplikasi

 */