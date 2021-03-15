fun main(){
    println(highAndLow("17 2 -3 4 5 6"))
}

fun highAndLow(numbers: String): String {
    var max = -100000
    var min = 100000
    val tmp = numbers.split(" ")
    val tmp2 = mutableListOf<Int>()
    tmp.forEach { tmp2.add(it.toInt()) }
    tmp2.forEach {
        if(it>max){max = it}
        if(it<min){min = it}
    }
    return "$max $min"
}

fun highAndLow1(numbers: String) = numbers.split(' ').map(String::toInt).let { "${it.max()} ${it.min()}" } // from internet