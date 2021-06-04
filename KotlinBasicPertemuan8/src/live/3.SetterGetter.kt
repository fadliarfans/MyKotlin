package live

class Mamal{
    private var weight = 0
    fun setWeight(value:Int){
        weight = value
    }

    fun getWeight():Int{
        return weight
    }
}

fun main(){
    val kucing = Mamal()
    kucing.setWeight(5)
    println("Berat kucingnya adalah ${kucing.getWeight()} Kg")
}