fun main() {
    val a = Array(3) {
        Array(3) { Array(3) { 0 } }
    }
    println(a.contentDeepToString())
}
