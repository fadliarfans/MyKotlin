fun main(){

    val arrCampur = arrayOf(1,2,true,"sapi")
    val arrNumber = intArrayOf(1,2,3,4,5)
    val arrFloat = floatArrayOf(1.1F ,2.3F ,3.4F)
    val arrLong = longArrayOf(10000L ,20000L ,40000L)

    // output Tanpa For
    println(arrCampur[0])
    println(arrCampur[1])
    println(arrCampur[2])
    println(arrCampur[3])

    println()

    for (i in arrNumber)                  // for dengan array cara 1
        println(i)

    println()

    for (i in 0..4){                      // isi ulang arrNumber jadi 10 semua isinya
        arrNumber[i] = 10
    }

    for (i in arrNumber)                  // for dengan array cara 1
        println(i)

    println()

    for (i in 0 until arrNumber.size)     // for dengan array cara 2
        println(arrNumber[i])

    // Array 2 dimensi
    val arr2dimensi = arrayOf(arrCampur, arrayOf(1,2,true,"sapi"), arrayOf(1,2,3,4), arrayOf("sapi","kambing","ayam","kuda"))

    // Output Array 2 Dimensi
    for (i in 0..3){
        for (j in 0..3){
            print(" ${arr2dimensi[i][j]}")
        }
        println()
    }




    val arr2dimensi2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))

    println()

    print(arr2dimensi2[0][0])    // cara ngeprint array manual
    print(arr2dimensi2[0][1])
    print(arr2dimensi2[0][2])

    println()

    print(arr2dimensi2[1][0])
    print(arr2dimensi2[1][1])
    print(arr2dimensi2[1][2])

    println()

    print(arr2dimensi2[2][0])
    print(arr2dimensi2[2][1])
    print(arr2dimensi2[2][2])

    println()
    println()

    for (i in 0..2){                // cara ngeprint array pake for
        for (j in 0..2){
            print(arr2dimensi2[i][j])
        }
        println()
    }





}