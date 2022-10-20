package org.test;

fun main() {
    val report = readln()
    //write your code here.
    val regex = "^(?<count>\\d+) wrong answers$".toRegex()
    val count = regex.matchEntire(report)
        ?.let { matchResult ->
            matchResult.groups.get(1)
                ?.value
                ?.toInt()
        } ?: throw IllegalStateException()
    println(count < 10)
}
