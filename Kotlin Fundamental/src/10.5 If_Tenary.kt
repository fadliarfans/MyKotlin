fun main(){
    val a = 10
    val b = if(a>5) 100 else 50
    val c = if(a>5) 200 else if(a<5) 100 else 50
    println("b = $b")
    println("c = $c")
}
