fun main(){
    val x = 20
    val y = 10

    if(x<20){                       // percabangan
        println("x kurang dari 20")
    }else if(x>20){
        println("x lebih dari 20")
    }else{
        println("x sama dengan 20")
    }

    if(x<20){                       // percabangan bersarang
        if(y<20){
            println("x dan y kurang dari 20")
        }else{
            println("x kurang dari 20 dan y tidak kurang dari 20")
        }
    }

    when(x){                        // when
        10 -> println("x nilainya 10")
        20 -> println("x nilainya 20")
        30 -> println("x nilainya 30")
        40 -> println("x nilainya 40")
        else -> println("x nilainya tidak ada didalam kondisi when")
    }

    val z =
        if(x<20) "x nya kurang dari 20"
        else if(x>20) "x nya lebih dari 20"
        else  "x nya sama dengan 20"
    println(z)

}