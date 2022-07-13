fun main() {
    val numbers = (0 until 100).map { 0 }
        .toMutableList()// put your code here
    numbers[0] = 1
    numbers[9] = 10
    numbers[99] = 100
    // do not touch the lines below 
    println(numbers.joinToString())
}
