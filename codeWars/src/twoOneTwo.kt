fun main(){
    val a = "xyaabbbccccdefww"
    val b = "xxxxyyyyabklmopq"
    print(longest(a, b))

}

fun longest(s1:String, s2:String):String {
    val sortedList = mutableListOf<Char>()
    var sortedString = ""
    (s1+s2).forEach {
        if(!sortedList.contains(it))
            sortedList.add(it)
    }
    sortedList.sorted().forEach {
       sortedString+=it
    }
    return sortedString
}