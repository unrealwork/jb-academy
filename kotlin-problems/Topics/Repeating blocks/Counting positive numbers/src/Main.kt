fun main() {
    // put your code here
    val n = readLine()!!.toInt();
    val res = (0 until n)
        .map { _ -> readLine()!!.toInt() }
        .count { it > 0 }
    
    println(res)
}
