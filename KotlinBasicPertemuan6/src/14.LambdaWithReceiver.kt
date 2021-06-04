fun main(args: Array<String>) {
    println(123.represents("123"))             // Lambda's with Receiver

    println(123.represents2("123"))    // extension functions
}

val represents: Int.(String) -> Boolean = {this == it.toInt()}  // Lambda's with Receiver

fun Int.represents2(another: String) = toString() == another    // extension functions

