import java.util.*

fun main(){
    var i = 0
    var j = 0
    val input = Scanner(System.`in`)
    var x = 0
    var a = 'A'
    x = input.nextInt()

    x--

    for(i in 0..x) {
        for (j in x downTo i)
            print(" ")
        for (j in 0..i)
          print(a++)
        for (j in 0..i-1)
            print(a++)
        println()
    }

    a--

    for(i in 0..x+x+2)
        print("*")
    println()

    for(i in 0..x){
        for(j in 0..i)
            print(" ")
        for(j in x downTo i)
            print(a--)
        for(j in x-1 downTo i)
            print(a--)
        println()
    }
}