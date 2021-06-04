package live


abstract class Animal2{
    var name = ""
    open fun eat(){
        println("$name sedang makan")
    }
}

class Cat2:Animal2(){
    override fun eat(){
        println("$name sedang makan Ikan")
    }
}

class Dog2:Animal2(){
    override fun eat(){
        println("$name sedang makan Daging")
    }
}

class Cow2:Animal2(){
    override fun eat(){
        println("$name sedang makan Rumput")
    }
}

fun main(){
    val kucing = Cat2()
    kucing.name = "kucing"
    kucing.eat()

    val anjing =  Dog2()
    anjing.name = "anjing"
    anjing.eat()

    val sapi = Cow2()
    sapi.name = "Sapi"
    sapi.eat()
}