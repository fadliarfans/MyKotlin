
fun main(){
    print("Masukan banyak data : ")
    val  banyakdata = readLine()?.toInt()?:0
    val arr = IntArray(banyakdata)

    for(i in 0 until banyakdata){
        print("data ke-${i+1} : ")
        arr[i]= readLine()?.toInt()?:0
    }

    val lastindex = banyakdata - 1
    var temporary: Int

    print("Mau berapa kali di rotate : ")
    val banyakrotate = readLine()?.toInt()?:0


    for (i in 1..banyakrotate) {
        for (j in 0 until lastindex) {
            temporary = arr[lastindex - j]
            arr[lastindex - j] = arr[lastindex - j - 1]
            arr[lastindex - j - 1] = temporary
        }
    }
    for(index in 0..lastindex)
        print("${arr[index]} ")
}
/*


123   312

123

132
312

321
231


*/
