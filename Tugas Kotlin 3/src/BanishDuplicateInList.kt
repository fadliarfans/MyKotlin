
fun main(){
    val list = mutableListOf<Int>()
    print("Masukan Banyaknya data : ")
    val banyakdata = readLine()?.toInt()?:0
    val lastindex = banyakdata -1
    var count = 0
    for(i in 0..lastindex){
        print("data ke-${i+1} : ")
        list.add(readLine()?.toInt()?:0)
    }
    for(i in 0 until lastindex-count){  // 0..8
        for(j in i+1..lastindex-count){  //i..9
            if(list[i]==list[j]){
                list.removeAt(j)
                count++
            }
        }
    }
    print(list)

}