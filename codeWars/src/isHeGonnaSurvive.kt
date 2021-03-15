fun main(){
    println(hero(2,1))
    println(hero(3,1))
    println(hero(4,2))
    println(hero(1,1))
    var a ="sd"
    a.substring(1)
}

fun hero(bullets: Int, dragons: Int) : Boolean = (bullets/dragons >=2)