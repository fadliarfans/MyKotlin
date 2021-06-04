fun main(){
    println(hitung(2,twice))
    println(hitung(2,slice))
}

val twice:(Int)->Int= {value:Int -> value * 2 }
val slice:(Int)->Int= {value:Int -> value / 2 }

fun hitung(value:Int, rumus:(Int)->Int):Int{
    return rumus(value)
}