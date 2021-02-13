fun main(){
    val a = 70
    val b = arrayOf(90,100)

    when(a){
        50 -> println("Very Bad")
        60 -> println("Bad")
        70 -> println("Good")
        80 -> println("Very Good")
        90 -> println("Very Very Good")
        100 -> {println("Excellent")}
        else -> {
            println("be patient")}
    }

    when(a){
        10,20,30 -> println("study more!!!")
        else -> print("")
    }

    when(a){
        in b -> println("you're great")
        !in b -> println("practice some more")
        else ->{
            print("")
        }
    }

    when(a){
        is Int -> println("this is integer")
        else -> println("this is not integer")
    }

}