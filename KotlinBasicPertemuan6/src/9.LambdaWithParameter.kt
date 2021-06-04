fun main(){
    hello("Fadli")
    hai("Fadli")
}

private val hello = {nama:String -> println("Hello !! $nama")}

private fun hai(nama:String){
    println("Hai !! $nama")
}
