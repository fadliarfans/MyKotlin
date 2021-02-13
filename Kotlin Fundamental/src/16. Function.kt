fun main(){
    wkwk()
    taktak(10)
    gumgum()
    gumgum(10)
    bangbang(i = 1, k= 3 , j = 2)     // function named argument
    lengleng()
    println(gogo())
    weiwei()
    println(woiwoi())
    bongbong('a',1,3,4,5,6,7)  // karena menggunakan varargs jadi bisa banyak
    val x = 5.kali10()               //  extension function
    println(x)
    println(5 kali 5)                 // menggunakan Function Infix Notation
    println(polpol(5))
    println(pilpil(0))
    println(factorial(5))
    values(20)
}


fun wkwk(){           // function
    println("wkwk")
}

fun taktak(i:Int){    // function with parameter
    for(j in 0..i){
        print("taktak")
    }
}

fun gumgum(i:Int = 10){  // function with default parameter
    for (j in 0..i){
        print("gumgum")
    }
}

fun bangbang(i:Int, j:Int, k:Int){
    println(i+j+k)
}

fun lengleng():Unit{            // void function ( unit berarti tidak mengembalikan apa-apa)
    print("lengleng")
}

fun gogo():String{              // function return type
    return "gogo"
}

fun weiwei():Unit = println("weiwei")     // single expression function
fun woiwoi():String = "woiwoi"

fun bongbong(i:Char,vararg j:Int){         // function varargs parameter ( variabel parameter terakhir boleh diisi banyak input )
    for(x in j){
        println(x)
    }
    print(i)
}

fun Int.kali10() : Int{                  // extension function
    return this*10
}

infix fun Int.kali(value:Int):Int{          // Function Infix Notation
    return this*value
}


fun polpol(i:Int):String{                   // return if
    return if(i>0){ "positif" }
    else if(i<0){ "negatif" }
    else {"enol" }
}

fun pilpil(i:Int):String = when(i){         // return when
    0 -> "enol"
    1 -> "satu"
    2 -> "dua"
    else ->"wkwk"
}


fun factorial(n:Int):Int = if(n>1){factorial(n-1)*n}else{1}  // recursive funtion

tailrec fun values(n:Int){      //tailrec recursive function
    println(n)
    if(n>1){
        values(n-1)
    }
}






