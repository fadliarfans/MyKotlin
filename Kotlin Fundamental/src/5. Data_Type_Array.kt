
fun main(){
    val a = arrayOf(10,20,30,40,60,70,80)

    println("panjang array : "+a.size)              // panjang array
    println("data array pada index[0] : "+a.get(0)) // mendapat data di posisi index
    a.set(0,100)                                    // mengubah data di posisi index
    println("data array pada index[0] : "+a[0])     // mendapat data di posisi index
    a[0] = 200                                      // mengubah data di posisi index
    println("data array pada index[0] : "+a[0])     // mendapat data di posisi index

    val b:Array<String?> = arrayOfNulls(5)     // nullable array
    b[0] = null
    b[1] = "notnull"
}