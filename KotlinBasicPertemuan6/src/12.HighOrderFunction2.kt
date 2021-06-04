fun main(){
    println(hitung2(2){value:Int -> value *2})
    println(hitung2(2){value:Int -> value /2})
}

fun hitung2(value:Int, rumus:(Int)->Int):Int{
    return rumus(value)
}