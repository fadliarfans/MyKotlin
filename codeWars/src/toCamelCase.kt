fun main(){
    println(toCamelCase("the-stealth-warrior"))
    println(toCamelCase("The_Stealth_Warrior"))
}
fun toCamelCase(str:String):String{
    var sign = true
    var newStr = ""
    str.forEach {
        if(it == '-' || it == '_'){
            sign = false
        } else if(sign){
            newStr += it
        }else{
           newStr+=it.toUpperCase()
            sign = true
        }
    }
    return newStr
}