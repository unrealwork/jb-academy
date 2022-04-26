fun main() {
    // write your code here
    val g = 9.8
    val density = readFloat()
    val height = readFloat()

    val pressure = density * g * height
    println(pressure)
}

private fun readFloat() = readln().toDouble()
