fun main(){
    println(tambah(7,4))
    println(kali(7,4))
    println(kurang(7,4))
}

typealias aritmathic = (Int, Int) -> Int

val tambah:aritmathic = {a:Int, b:Int -> a+b}
val kali:aritmathic   = {a:Int, b:Int -> a*b}
val kurang:aritmathic = {a:Int, b:Int -> a-b}

