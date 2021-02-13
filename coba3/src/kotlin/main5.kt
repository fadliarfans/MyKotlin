fun main() {
    // class kalo di java namanya pojo
    // pojo sama seperti membuat tipe data baru
    // kalo di java constructernya agak ribet

    val user = User(firstname = "sapi", lastname = "kuda", email = "efew", password = "efwfe")  // class
    val nama = user.firstname

    print(nama)


    val sapi = listOf("a", "b", 4, user.lastname)
    val kuda = mutableListOf("a", "b", "c")     // bisa di ubah

    val sets = setOf<Any>("a", 2, true)
    // di sets ada union dan intersect seperti himpunan dan ada juga yang mutable

    val capital = mapOf(
            "jakarta" to "indonesia",
            "london" to "Inggris"
    )
    val tmp = capital["jakarta"]
    println(tmp)

    val capital2 = mutableMapOf(       // mutablemapof
            "jakarta" to "indonesia",
            "london" to "Inggris"
    )

    capital2.put("Medan","Indonesia")

    val number1 = listOf(1,2,3,4,5,6,7,8,10)
    val even = number1.filter{it % 2 ==0}        // filter
    val multiple = number1.map { it*2 }          // map
    val finding = number1.find { it%3==0 }           // find
    val finding2 = number1.first()                    // first
    val finding3 = number1.last { it%3==0 }           // last
    val sum = number1.sum()
    val sort1 = number1.sorted()                  // sorting
    val sort2 = number1.sortedDescending()

    val list = (1..100000).toList()
    list.filter { it%5==0 }.map{it*2}.forEach{ println(it)}   // mantoppp !!!!

    print(number1.count())
    print(number1.count {it % 3 == 0})                       //count




 }