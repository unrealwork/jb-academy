import kotlin.math.abs

fun main() {
    // write your code 
    val (x1, y1) = readLine()!!.split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.split(" ").map { it.toInt() }
    val xDiff = abs(x1 - x2)
    val yDiff = abs(y1 - y2)
    val isBeaten = xDiff == 1 && yDiff == 2 || xDiff == 2 && yDiff == 1
    println(if (isBeaten) "YES" else "NO")
}
