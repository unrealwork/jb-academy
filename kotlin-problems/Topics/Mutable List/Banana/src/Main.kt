fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    // put your code here
    strings.replaceAll { if (it == str) "Banana" else it }
    return strings
} 
