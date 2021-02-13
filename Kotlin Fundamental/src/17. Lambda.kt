fun main(){
    println(kali10(5))
    println(kali20(5))
    println(kali30r(5))

}


val kali10:(Int) -> Int = {n:Int -> n * 10}  // lambda_expression di variabel

val kali20:(Int) ->Int = {it*20}             // lambda_expression di variabel dengan it

fun kali30(n:Int) = n * 30

val kali30r:(Int) -> Int = :: kali30         // Method References

/*

- Function di kotlin adalah first-class citizens, artinya dianggap seperti tipe data yang lainnya.
- Bisa disimpan di variable, array, bahkan bisa dikirim ke parameter function itu sendiri
- Lambda expression secara sederhana adalah function yang tidak memiliki nama
- Biasanya saat kita membuat function, kita akan selalu membuat menggunakan kata kunci fun dan
  mendeklarasikan nama function nya
- Dengan lambda expression, kita bisa membuat function tanpa harus mendeskripsikan function nya

 */