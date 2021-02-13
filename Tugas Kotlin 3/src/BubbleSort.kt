
fun main() {
    var tmp:Int
    print("masukan berapa jumlah data : ")
    val n = readLine()?.toInt() ?: 0
    val arr = IntArray(n)
    for (i in 0 until n){
        print("data ke-${i+1} : ")
        arr[i] =  readLine()?.toInt()?:0
    }


    print("sebelum diurutkan : ")
    for (i in 0 until n)
        print(" ${arr[i]}")

    println()
    for(i in 0 until n-1){
        for(j in 0 until n-1){
            if(arr[j]>arr[j+1]){
                tmp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = tmp
            }
        }
    }
    print("setelah diurutkan : ")
    for (i in 0 until n)
        print(" ${arr[i]}")
}
