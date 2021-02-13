fun main(){
    val kali10:(Int)->Int = {i:Int -> i*10}
    val kali2:()->Int = {2}



    println( fungsiKali10i(5, kali10))
    println( fungsiKali20i(5, kali10, kali2))
}

inline fun fungsiKali10i(value:Int,fungsiKali:(Int)->Int):Int{
    return fungsiKali(value)
}

/*
-  Menggunakan Higher-Order Function adalah salah satu fitur yang sangat berguna.
-  Namun penggunaan Higher-Order Function akan berdampak terhadap performa saat aplikasi
   berjalan, karena harus membuat object lambda berulang-ulang. Jika penggunaannya tidak terlalu
   banyak mungkin tidak akan terasa, tapi jika banyak sekali, maka akan terasa impact nya
-  Inline Functions adalah kemampuan di Kotlin yang mengubah Higher-Order Function menjadi
   Inline Function
-  Dimana dengan Inline Function, code di dalam Higher-Order Function akan di duplicate agar pada
   saat runtime, aplikasi tidak perlu membuat object lambda berulang-ulang
 */

inline fun fungsiKali20i(value:Int,noinline fungsiKalia:(Int)->Int, fungsiKalib:()->Int):Int{
    return fungsiKalia(value) * fungsiKalib()
}

/*
- Saat menandai bahwa function adalah inline, maka secara otomatis semua parameter akan menjadi
  inline
- Jika kita ingin memberi tahu bahwa jangan melakukan inline terhadap parameter, kita bisa
  menandai parameter tersebut dengan kata kunci noinline
 */