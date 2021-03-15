fun main() {
    print(getMiddle("sapi"))
}

fun getMiddle(word: String): String = if (word.length % 2 == 0) {
        word.substring(word.length / 2 - 1, word.length / 2 + 1)
    } else {
        word[word.length / 2].toString()
    }


