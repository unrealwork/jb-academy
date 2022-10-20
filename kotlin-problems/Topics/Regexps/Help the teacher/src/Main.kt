fun main() {
    val report = readLine()!!
    //write your code here.
    val regex = "^(?<count>\\d+) wrong answer[s]*$".toRegex()
    val count = regex.matchEntire(report)
        ?.let { matchResult ->
            matchResult.groups[1]
                ?.value
                ?.toInt()
        } ?: throw IllegalStateException()
    println(count < 10)
}
