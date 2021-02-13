fun main(){
    println(fungsiKali10a(10))
}


var fungsiKali10a = fun(value:Int):Int{
    return value * 10
}

/* - Lambda akan menganggap baris terakhir di blok lambda sebagai hasil kembalian
   - Kadang kita butuh membuat lambda yang se flexible function, dimana kita bisa mengembalikan
     hasil dimanapun
   - Untuk hal ini, kita bisa menggunakan Anonymous Function
   - Anonymous Function sebenarnya mirip dengan lambda, hanya cara membuatnya saja yang sedikit
     beda, masih menggunakan kata kunci func*/