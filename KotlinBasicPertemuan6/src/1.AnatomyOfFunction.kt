fun main(){
    println(sum(10,20))
    println(sum2(10,20))
}

public fun sum(a:Int ,b:Int):Int{
    return a+b
}

private fun sum2(a:Int ,b:Int):Int{  // function header
    return a+b                       // function body
}

/*
 Penjelasan function header

 private / public  = untuk mengatur bagaimana hak akses dari sebuah kelas, fungsi, properti dan variabel (visibility modifier)
 fun               = untuk menandakan jika baris kode tersebut merupakan sebuah fungsi
 (a:Int ,b:Int)    = data atau nilai yang disematkan ketika fungsi tersebut dipanggil (Function Parameter)
 :Int              = untuk menandakan tipe yang akan dikembalikan fungsi tersebut (Function return type)
 */

/*
public    = visible to any client who can see the declaring class
private   = visible inside the class only
protected = visible inside the class and its subclasses
internal  = visible to any client inside the module that can see the declaring class
 */


