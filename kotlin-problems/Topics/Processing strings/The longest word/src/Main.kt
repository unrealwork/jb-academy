fun main() {
    // write your code here    
    val s = readLine()!!
    val res = s.split(' ')
        .maxByOrNull { it.length }
    println(res)
}
