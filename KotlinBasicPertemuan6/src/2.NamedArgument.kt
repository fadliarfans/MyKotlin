fun main(){
    println(getFullName("fadli","Arfans","Hakim"))

    println(getFullName(first = "fadli", middle = "arfans",last = "hakim")  ) // NamedArgument

    println(getFullName(middle = "arfans",first = "fadli",last = "hakim"))    // NamedArgument
}

fun getFullName(first:String, middle:String, last:String):String{
    return "$first $middle $last"
}
