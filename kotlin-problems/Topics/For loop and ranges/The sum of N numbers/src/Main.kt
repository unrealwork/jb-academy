fun main() {
    // write your code here
    val count = readLine()!!.toInt()
    var sum = 0
    for (i in 1..count) {
        sum += readLine()!!.toInt()
    }
    println(sum)
}
