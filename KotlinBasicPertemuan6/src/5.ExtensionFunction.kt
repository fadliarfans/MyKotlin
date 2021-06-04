fun main(){
    2.tampilkan()
    3.5.tampilkanDanKaliDua()
    3.7.tampilkanDanKaliDua()

    val a = 20000
    a.toRupiah()
    println(a.slice2())
}

fun Int.tampilkan(){
    println("Angkanya adalah $this")
}

fun Double.tampilkanDanKaliDua(){
    println("Angkanya adalah ${this * 2}")
}

fun Int.toRupiah(){
    println("Rp $this")
}

fun Int.slice2():Int{
    val a = this+1000
    return a/2
}