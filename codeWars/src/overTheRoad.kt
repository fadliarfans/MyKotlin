fun main(){
    println(overTheRoad(1,3))
    println(overTheRoad(2,3))
    println(overTheRoad(3,3))

}

fun overTheRoad(address: Int, n: Int): Int {
    //code here
    return if(address % 2 ==0){
        n*2 - (address-1)
    }
    else{
        (n*2 - address) +1
    }
}

