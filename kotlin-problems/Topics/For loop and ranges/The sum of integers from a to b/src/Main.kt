fun main() {
    // put your code here
    val start = readLine()!!.toInt()
    val end = readLine()!!.toInt()

    var sum = 0;
    for (i in start..end) {
        sum += i
    }
    println(sum)
}
