
// high order function adalah fungsi yang parameternya menggunakan fungsi atau fungsi yang mengembalikan fungsi

fun main(){

    print(fungsiKali10(10, fungsiKali10e))
    println(fungsiKali20e)

}


fun fungsiKali10(value:Int, fungsid:(Int)->Int):Int{
    return fungsid(value) * 10
}

var fungsiKali10e = { a:Int -> a*10}   // versi lambda tapi gapake " :(Int)->Int

val fungsiKali20e = fungsiKali10(10){a:Int -> a*20}  // trailing lambda


/* - Higher-Order Function adalah function yang menggunakan function sebagai parameter atau
     mengembalikan function
   - Penggunaan Higher-Order Function kadang berguna ketika kita ingin membuat function yang
     general dan ingin mendapatkan input yang flexible beruba lambda, yang bisa dideklarasikan oleh si
     user ketika memanggil function tersebut   */