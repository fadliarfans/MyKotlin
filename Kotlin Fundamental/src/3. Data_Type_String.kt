
fun main(){
    val a = "Dragon"

    val b ="""Dragon 
        |master
        |Mantap
    """.trimMargin()

    val c = "saya memelihara ${a+b}"   // String template

    println(a)
    println(b)
    println(c)

}