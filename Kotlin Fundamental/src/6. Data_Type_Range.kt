

fun main(){
    val a = 0..1000
    val b = 0..1000 step 2
    val c = 100 downTo 0
    val d = 100 downTo 0 step 5
    println("a")
    println("total          : "+a.count())              //Mendapatkan total data di range
    println("mengecek(150)  : "+a.contains(150))        //Mengecek apakah terdapat value tersebut
    println("nilai pertama  : "+a.first)                //Mendapatkan nilai pertama
    println("nilai terakhir : "+a.last)                 //Mendapatkan nilai terakhir
    println("nilai kenaikan : "+a.step)                 //Mendapatkan nilai tiap kenaikan
    println("")

    println("b")
    println("total          : "+b.count())              //Mendapatkan total data di range
    println("mengecek(150)  : "+b.contains(150))        //Mengecek apakah terdapat value tersebut
    println("nilai pertama  : "+b.first)                //Mendapatkan nilai pertama
    println("nilai terakhir : "+b.last)                 //Mendapatkan nilai terakhir
    println("nilai kenaikan : "+b.step)                 //Mendapatkan nilai tiap kenaikan
    println("")

    println("c")
    println("total          : "+c.count())              //Mendapatkan total data di range
    println("mengecek(150)  : "+c.contains(150))        //Mengecek apakah terdapat value tersebut
    println("nilai pertama  : "+c.first)                //Mendapatkan nilai pertama
    println("nilai terakhir : "+c.last)                 //Mendapatkan nilai terakhir
    println("nilai kenaikan : "+c.step)                 //Mendapatkan nilai tiap kenaikan
    println("")

    println("d")
    println("total          : "+d.count())              //Mendapatkan total data di range
    println("mengecek(150)  : "+d.contains(150))        //Mengecek apakah terdapat value tersebut
    println("nilai pertama  : "+d.first)                //Mendapatkan nilai pertama
    println("nilai terakhir : "+d.last)                 //Mendapatkan nilai terakhir
    println("nilai kenaikan : "+d.step)                 //Mendapatkan nilai tiap kenaikan
    println("")

}