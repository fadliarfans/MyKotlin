fun main(){
    val list = mutableListOf<Mobil>()
    val mobil = Mobil()
    list.add(mobil)
    println(list.last().roda)
    dikali2(list)
    println(list.last().roda)

}
fun dikali2(list2: MutableList<Mobil>){
    list2.last().roda = "wkwkwk"
    println(list2.last().roda)
}

class Mobil{
    var roda = "NoName"
}