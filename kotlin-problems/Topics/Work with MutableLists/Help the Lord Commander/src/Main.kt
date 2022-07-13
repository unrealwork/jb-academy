fun main() {
    val beyondTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val backToTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    // do not touch the lines above
    // write your code here
    val res = backToTheWall.size == beyondTheWall.size &&
            backToTheWall.all { beyondTheWall.contains(it) } &&
            beyondTheWall.all { backToTheWall.contains(it) }
    println(res)
}
