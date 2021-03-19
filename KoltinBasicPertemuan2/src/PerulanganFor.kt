fun main(){

    for(i in 0..5){
        println("i ke $i")
    }

    println()

    for(i in 5 downTo 0){
        println("i ke $i")
    }

    println()

    for(i in 0..6 step 2){
        println("i ke $i")
    }

    println()

    var x = 0
    while (x<5){
        println("x ke $x")
        x++
    }

    println()

    var y = 0
    do {
        println("y ke $y")
        y+=2
    }while (y<10)


    for(i in 0..5){
        for(j in 0..5){
            print(" $j ")
        }
        println()
    }

    for(i in 0..5){
        for(j in 0..i){
            print(" $j ")
        }
        println()
    }

    for(i in 0..5){
        for(j in 5 downTo i){
            print(" $j ")
        }
        println()
    }



}