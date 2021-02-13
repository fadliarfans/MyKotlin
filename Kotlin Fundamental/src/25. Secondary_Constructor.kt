fun main(){

    val animal1 = Animal("kambing", 10,23)
    val animal2 = Animal("Sapi", 40,50, true)

    println(animal1.name)
    println(animal2.name)

}

class Animal(name:String , weight:Int, height:Int){
    var name:String = "default"
    var weight:Int = 0
    var height:Int = 0
    var isMammal:Boolean = false
    constructor(name:String , weight:Int, height:Int, isMammal:Boolean):this(name, weight, height){ //secondary constructor
        this.isMammal = isMammal
        this.name = name
        this.weight = weight
        this.height = height
    }
    init {
        this.name = name
        this.weight = weight
        this.height = height
    }
}