fun main(){
    print(findShort("saya makan baso mantap sekali aa ddf fdfdf"))
}

fun findShort(s: String): Int = s.split(" ").map { it.length }.let { it.min()?:0 }
