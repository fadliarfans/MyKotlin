fun main(){
    println(getFullName2(middle = "Kecap"))
}

fun getFullName2(first:String = "Ayam",middle:String = "Bakar",last:String ="Sedap"):String{
    return "$first $middle $last"
}
