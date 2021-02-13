fun main (){

    val b = A()
    val c = A()
    b.x = 10000
    c.x = 10000
    ubah(b)
    println(b.x)
    println(c.x)

}

fun ubah(y:A){
    y.x = 5
}