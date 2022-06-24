fun main() {
    val s = readLine()!!
    val res = s.split(' ')
        .maxByOrNull { it.length }
    println(res)  
}
