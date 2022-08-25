import kotlin.math.*

fun main() {
    // put your code here
    val a = readDouble()
    val b = readDouble()
    val c = readDouble()
    val p = (a + b + c) / 2
    val area = sqrt(p * (p - a) * (p - b) * (p - c))
    println(area)
}

private fun readDouble() = readln().toDouble()
