fun main(){
    println(sum(1,2,3,4,5,6,7,8,9,10))
}

fun sum(vararg number:Int):Int{
    return number.sum()
}