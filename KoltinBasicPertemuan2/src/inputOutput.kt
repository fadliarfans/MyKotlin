import java.util.*

fun main(){
    val input = Scanner(System.`in`)        // java
    val word = input.nextLine()
    print("inputan mengunakan java           : ")
    System.out.println(word)

    print("inputan mengunakan Kotlin(string) : ")
    val word2 = readLine()                 // kotlin
    println(word2)

    print("inputan mengunakan Kotlin(int)    : ")
    val number = readLine()?.toInt()
    println(number)

    print("inputan mengunakan Kotlin(boolean : ")
    val sign = readLine().toBoolean()
    println(sign)





}