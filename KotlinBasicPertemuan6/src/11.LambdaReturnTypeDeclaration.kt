fun main(){
    println(bagi10(200))
    println(bagi30(900.0))
}

val bagi10 :(Int)->Int = {value:Int -> value/10}

val bagi30 :(Double)->String ={value:Double -> (value/30).toString()}

