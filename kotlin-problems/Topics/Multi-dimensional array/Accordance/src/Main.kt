fun main() {
    // put your code here
    val res: Array<Array<String>> = Array(2) { Array(3) { "" } }
    for (i in 0 until 2) {
        for (j in 0 until 3) {
            res[i][j] = "[$i][$j]"
        }
    }
    println(res.contentDeepToString())
}
