fun main(){
    println(past(1,2,3))
}
fun past(h: Int, m: Int, s: Int): Int = (h*3600+m*60+s)*1000