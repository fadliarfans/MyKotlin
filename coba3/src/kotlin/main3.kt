fun main() {
    val anytipe: Any = 100L                    // any dan long

    val colorRed = Color.RED                   // this is statement
    val colorBlue = Color.BLUE
    val colorGreen = Color.GREEN               // ctrl + alt + L = meraphikan
    val a: Int
    val value = readLine()?.toInt()

    a = 5                                       // this is expressions


    when (value) {
        1 -> println("angka 1")
        2 -> {
            print("angka 2")
        }
        else -> print(" angka ga ada")


    }
    val rangeInt = 1..10 step 2         // range
    rangeInt.forEach {
        print("$it")
    }
    println(rangeInt.step)                          // print step nya

    val listOfInt = listOf(1,2,3,null,5,null,7)
    for(i in listOfInt){
        if(i==null) continue       // continue
        print(i)
    }

    for(i in listOfInt){
        if(i==null) break            //break
        print(i)
    }

    

}

enum class Color(val value: Int) {
    RED(0xFF0000),
    BLUE(0x00FF00),
    GREEN(0x0000FF)
}
