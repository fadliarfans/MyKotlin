fun main(){
    print(isDivisible(10,5,2))
}

fun isDivisible(n: Int, x: Int, y: Int): Boolean = (n%x==0 && n%y==0)