/*
//tipe data
var identifier: Type = initialization
var company: String = "Dicoding"
company = "Dicoding Academy"

val firstWord = "Dicoding "
val lastWord = "Academy"
print(firstWord + lastWord)

//character
var vocal = 'A'

println("Vocal " + vocal++)
println("Vocal " + vocal++)
println("Vocal " + vocal++)
println("Vocal " + vocal--)
println("Vocal " + vocal--)
println("Vocal " + vocal--)
println("Vocal " + vocal--)

//string
val text  = "Kotlin"
val firstChar = text[0]

print("First character of $text is $firstChar")

//escaped string
val statement = "Kotlin is Awesome!"

val statement = "Kotlin is "Awesome!""

\t: menambah tab ke dalam teks.
\n: membuat baris baru di dalam teks.
’: menambah karakter single quote kedalam teks.
”: menambah karakter double quote kedalam teks.
\: menambah karakter backslash kedalam teks.

//print unicode
val name = "Unicode test: \u00A9"
print(name)

//raw string
val line = "Line 1\n" +
        "Line 2\n" +
        "Line 3\n" +
        "Line 4\n"

val line = """
        Line 1
        Line 2
        Line 3
        Line 4
    """.trimIndent()

print(line)


//boolean
val officeOpen = 7
val officeClosed = 16
val now = 20

val isOpen = if (now >= officeOpen && now <= officeClosed){
    true
} else {
    false
}

print("Office is open : $isOpen")

//number
Int, Long, Short, Byte, Double

toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
*/
