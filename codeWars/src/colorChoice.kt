fun main(){
    println(checkchoose(3000, 33 ))
}

fun checkchoose(m:Long, n:Int):Long {
    var value:Long= 1
    var r:Long = 1
    var count: Long
    while(value!=m){
        value = 1
        count = 1
        for(i in n-r+1..n){
            value*= i
            value/= count++
        }
        if(r>n){
            r=0
            break
        }
        r++
    }
    return (r-1)
}