fun main (){
    println("Halo, Kotlin")
    val text: String? = null
    val x=text?.length?:40
    var i:Int
    val y = intArrayOf(1,4,8)
    val z = mutableListOf<Int?>()
    var j = 0
    println("-------- Program Pembalik urutan -----------")
    println()
    for(i in 0..10) {
        print("Masukan Nilai List Ke-$i : ")
        z.add(readLine()?.toInt())

    }
    for(i in 10 downTo  0)
        println("Array Z yang ke ${j++} jadinya isinya adalah ${z[i]}")




}