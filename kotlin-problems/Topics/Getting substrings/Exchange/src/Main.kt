fun main() {
    // put your code here
    val a = readln()
    if (a.length < 2) {
        println(a)
    } else {
        println(a[a.lastIndex] + a.substring(1, a.lastIndex) + a[0])
    }
}
