fun main(){


    val numberList = listOf(1,2,3,4,5,6,7,8,9,10,4,5,5,4,3)
    val listGenap = numberList.filter { it%2==0 }
    val listDikali5  = numberList.map { it*5 }
    val banyakDataDiList = numberList.count()
    val find3 = numberList.find { it % 2 == 3 }
    val firstbutcannull = numberList.firstOrNull{it % 2 == 3}
    val lastbutcannull = numberList.lastOrNull(){it % 2 == 3}
    val first = numberList.first()
    val last = numberList.last()
    val sum = numberList.sum()
    val sortedList = numberList.sorted()
    println(listGenap)
    println(listDikali5)
    println(banyakDataDiList)
    println(find3)
    println(firstbutcannull)
    println(lastbutcannull)
    println(first)
    println(last)
    println(sum)
    println(sortedList)
}