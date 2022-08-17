fun main() {
    val number = readln()
    // write your code here
    val res = number.replace("[a-zA-Z]+".toRegex(), "")
    println(res)
}
