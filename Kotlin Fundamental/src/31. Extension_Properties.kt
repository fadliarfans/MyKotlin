fun main(){
    val persegiPanjang4 = PersegiPanjang4(5,5)
    println(persegiPanjang4.panjangdanluas)
}

class PersegiPanjang4(val panjang:Int, val lebar:Int)

val PersegiPanjang4.panjangdanluas:String
    get() =  "panjang sama dengan ${this.panjang} dan lebar sama dengan ${this.lebar}"

/*
Kotlin dapat meng-extends sebuah fungsi pada kelas tanpa harus mewarisi kelasnya.
Hal ini dilakukan dengan deklarasi khusus yang disebut dengan Extension.
 */