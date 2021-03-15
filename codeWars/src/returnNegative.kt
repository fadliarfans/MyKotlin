fun main(){
   println( makeNegative(-2))
   println( makeNegative(2))
   println( makeNegative(0))
}

fun makeNegative(x: Int): Int {
    return if(x>0){
        x * -1
    }else{
        x
    }
}