fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    // write your code here
    val findRes = regexColors.findAll(text)
    for (findRe in findRes) {
        println(findRe.value)
    }
}
