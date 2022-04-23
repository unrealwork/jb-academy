fun main() {
    // put your code here
    val counts = arrayOf(0,0,0,0)
    repeat(readLine()!!.toInt()) {
        val grade = readLine()!!.toInt()
        counts[grade - 2]++
    }
    counts.forEach {
        print("$it ")
    }
}
