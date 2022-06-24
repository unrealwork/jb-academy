fun main() {
    // write your code here
    val a = readLine()!!.toInt()
    val message = if (a > 0) "positive" else if (a == 0) "zero" else "negative"
    println(message)
}
