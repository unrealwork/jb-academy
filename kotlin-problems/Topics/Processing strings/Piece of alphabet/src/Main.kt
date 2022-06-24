fun main() {
    // write your code here
    println(solve(readLine()!!))
}

fun solve(s: String): Boolean {
    for (i in 1 until s.length) {
        if (s[i] - s[i - 1] != 1) {
            return false
        }
    }
    return true
}
