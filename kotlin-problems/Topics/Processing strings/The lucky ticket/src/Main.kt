fun main() {
    // write your code here
    println(if (isLucky(readLine()!!)) "Lucky" else "Regular")
}

fun isLucky(s: String): Boolean {
    val left = s.substring(0, 3)
    val right = s.substring(3)
    return digitsSum(left) == digitsSum(right)
}

fun digitsSum(numString: String): Int {
    return numString.chars()
        .map { it - '0'.toInt() }
        .sum();
}
