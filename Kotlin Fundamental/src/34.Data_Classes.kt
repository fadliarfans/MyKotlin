fun main(){
    println(PersegiPanjang6(5,40))
    println(PersegiPanjang6(5,10).luas())
}

data class PersegiPanjang6(var panjang:Int, var lebar:Int){
    fun luas():Int{
        return panjang * lebar
    }
}