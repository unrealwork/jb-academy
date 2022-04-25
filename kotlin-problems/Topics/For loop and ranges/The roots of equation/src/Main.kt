fun main() {
    // put your code here
    val coef = generateSequence { readInt() }
        .take(4)
        .toList()
        .reversed()
    for (i in 0..1000) {
        var x = 1;
        var res = 0;
        for (c in coef) {
            res += x * c;
            x *= i;
        }
        if (res == 0) {
            println(i)
        }
    }
}

private fun readInt() = readLine()!!.toInt()
