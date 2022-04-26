import java.util.stream.Collectors

fun main() {
    // write your code here
    val message = readLine()!!.chars()
        .mapToObj() { it.toChar() }
        .map { "$it$it" }
        .collect(
            Collectors.joining()
        )
    println(message)
}
