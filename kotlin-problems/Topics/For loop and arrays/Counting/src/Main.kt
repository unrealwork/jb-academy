fun main() {
    // write your code here
    val size = readln().toInt()
    val arr = IntArray(size)
    for (i in 0 until size) {
        arr[i] = readln().toInt()       
    }
    val m = readln().toInt()
    println(arr.count { it == m })
}
