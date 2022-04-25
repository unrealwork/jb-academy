fun main() {
    // write your code here
    val start = readLine()!!.toInt()
    val end = readLine()!!.toInt()

    for (i in start..end) {
        var isFizzOrBuzz = false
        if (i % 3 == 0) {
            print("Fizz")
            isFizzOrBuzz = true
        }
        if (i % 5 == 0) {
            print("Buzz")
            isFizzOrBuzz = true
        }
        println("${if (isFizzOrBuzz) "" else i}")
    }
}
