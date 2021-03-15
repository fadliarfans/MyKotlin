fun main(){
    print(removeChar(""))
}

fun removeChar(str: String): String {
    // You got this!
    var newStr =""
    for(i in 1 until str.length-1){
        newStr+=str[i]
    }
    return newStr
}