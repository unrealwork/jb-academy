import kotlin.math.min

fun main() {
    // write your code here
    val size = readln().toInt()
    var min: Int? = null;
    for (i in 1..size) {
        val n = readln().toInt()
        min = if (min == null) {
            n
        } else {
            min(min, n )
        }
    }
    println(min)
}
