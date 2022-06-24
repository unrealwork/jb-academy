fun main() {
    // write your code here
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val num = readLine()!!.toInt()
    println(num in  a..b && num in c..d)
}
