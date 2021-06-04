package live

open class Animal{
    var name = ""
    open fun eat(){
        println("$name sedang makan")
    }
}

class Cat:Animal(){
    override fun eat(){
        println("$name sedang makan Ikan")
    }
}

class Dog:Animal(){
    override fun eat(){
        println("$name sedang makan Daging")
    }
}

class Cow:Animal(){
    override fun eat(){
        println("$name sedang makan Rumput")
    }
}

fun main(){
    val kucing = Cat()
    kucing.name = "kucing"
    kucing.eat()

    val anjing =  Dog()
    anjing.name = "anjing"
    anjing.eat()

    val sapi = Cow()
    sapi.name = "Sapi"
    sapi.eat()
}