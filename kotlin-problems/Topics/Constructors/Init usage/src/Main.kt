fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(t: Int) {
    val time: Byte

    init {
        time = when {
            t > Byte.MAX_VALUE -> Byte.MAX_VALUE
            t < Byte.MIN_VALUE -> Byte.MIN_VALUE
            else -> t.toByte()
        }
    }
}
