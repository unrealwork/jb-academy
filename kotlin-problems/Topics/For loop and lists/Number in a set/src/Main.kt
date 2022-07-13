fun main() {
    // write your code here
    val setSize = readln().toInt()
    val set = (0 until setSize).map { readln().toInt() }
        .toSet()
    val res = set.contains(readln().toInt())
    println(if (res) "YES" else "NO")
}
