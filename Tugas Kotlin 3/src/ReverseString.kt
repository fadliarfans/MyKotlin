
fun main(){
    print("Masukan kata : ")
    val kata:CharArray = readLine()?.toCharArray()!!
    val banyakdata = kata.size
    val n = banyakdata-1
    var tmp:Char?
    print("sebelum di puter : ")
    print(kata)
    for (i in 0..n){
        for (j in 0 until n-i){
            tmp = kata[n-j]
            kata[n-j] = kata[n-j-1]
            kata[n-j-1] = tmp
        }
    }
    println("")
    print("setelah di puter : ")
    print(kata)
}