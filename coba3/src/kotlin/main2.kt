fun main(){


    var baris :Int
    var tinggi :Int

    val tmp:Int?
    val tmp2:Int?

    print("masukan ingin berapa baris     :")
    tmp = readLine()?.toInt()?:0
    print("masukan ingin berapa tingginya :")
    tmp2 = readLine()?.toInt()?:0
    baris = tmp
    tinggi = tmp2

    tinggi--
    baris--

    for(kolom in 0..baris) {
        for (i in 0..tinggi) {
            for (j in 0..kolom) {
                for (k in tinggi downTo i)
                    print(" ")
                for (k in 0..i)
                    print("*")
                for (k in 0 until i)
                    print("*")
                for (k in tinggi + 1 downTo i)
                    print(" ")
            }
            println()
        }
        for (j in 0..kolom) {
            for (k in 0..tinggi * 2 + 2) {
                print("*")
            }
            print(" ")
        }
        println()
        for (i in 0..tinggi) {
            for (j in 0..kolom) {
                for (k in 0..i)
                    print(" ")
                for (k in tinggi downTo i)
                    print("*")
                for (k in tinggi - 1 downTo i)
                    print("*")
                for (k in 0..i + 1)
                    print(" ")
            }
            println()
        }
        println()
    }
}