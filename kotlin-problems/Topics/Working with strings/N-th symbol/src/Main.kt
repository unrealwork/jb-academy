fun main() {
    // write your code here
    val s = readLine();
    val index = readln().toInt()
    s?.let {
        println("Symbol # $index of the string \"$it\" is '${it[index - 1]}'")
    }
}
