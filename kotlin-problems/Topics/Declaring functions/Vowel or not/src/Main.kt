// write your function here

val vowels = charArrayOf('o', 'u', 'i', 'a', 'e')

fun main() {
    val letter = readLine()!!.first()
    println(isVowel(letter))
}

private fun isVowel(letter: Char): Boolean = letter.lowercaseChar() in vowels
