import kotlin.math.pow

fun main(){
    println(  digPow(89, 1) )
    println(  digPow(92, 1) )
    println(  digPow(695, 2) )
    println(  digPow(46288, 3) )

}

fun digPow(n: Int, p: Int): Int {
    val digitList = mutableListOf<Int>()
    var m = n
    var q = p
    while (m/1>0){
        digitList.add(m%10)
        m/=10
    }
    digitList.reverse()
    for(i in 0 until digitList.count()){
        val tmp = digitList[i]
        for(j in 1 until q){
            digitList[i]*=tmp
        }
        q++
    }
    return if(digitList.sum() % n == 0){
        digitList.sum()/n
    }else{
        -1
    }
}