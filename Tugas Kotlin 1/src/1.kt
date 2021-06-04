fun main() {
    val valueA = 101
    val valueB = 52
    val valueC = 99

    val resultA = calculateResult(valueA, valueB, valueC)
    val resultB = calculateResult(valueA, valueB, null)

    println("""
        ResultA is $resultA
        ResultB is $resultB
    """.trimIndent())

    println("""
        Program Pertambahan 2 Variabel antara variabel a = 101, b =52, dan c = 99
        
        Pilih salah satu :
        1. a + b
        2. a + c
        3. b + c
        
    """.trimIndent())

    print("Masukan Input  : ")
    val input = readLine()?.toInt()
    val resultC = pilihaja(valueA,valueB,valueC,input)
    println("Hasilnya adalah $resultC")
}

fun calculateResult(valueA: Int, valueB: Int, valueC: Int?): Int {
    val result :Int
    val tmp = valueC ?: 50

    result = valueA + (valueB - tmp)

    return result
}

fun pilihaja(valueA: Int, valueB: Int, valueC: Int, input: Int?):Int {
    val result:Int
    if(input==1)
        result = valueA + valueB
    else if (input == 2)
        result = valueA + valueC
    else if (input == 3)
        result = valueB + valueC
    else {
        result=0
    }

    return result
}

