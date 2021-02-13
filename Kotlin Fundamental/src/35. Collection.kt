fun main(){

    val list1 = listOf(1,2,2,3,4,5)
    val list2 = mutableListOf(1,2,2,3,4,5)
    val set1 = setOf(1,2,2,3,4,5)
    val map1 = mapOf(1 to 2,2 to 3,3 to 4)

    list2.add(6)
    list2.add(2,5)
    list2.removeAt(4)
    list2[4] = 10

    println(list1)
    println(list2)
    println(set1)
    println(map1)

}

/*
Collections sendiri merupakan sebuah objek yang bisa menyimpan kumpulan objek lain termasuk data class.
 Dengan collection kita bisa menyimpan banyak data sekaligus.
 Di dalam collections terdapat beberapa objek turunan, di antaranya adalah List, Set, dan Map.
 */
