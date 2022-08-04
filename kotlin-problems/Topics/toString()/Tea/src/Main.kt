open class Tea(open val cost: Int,open val volume: Int) {
    override fun toString(): String {
        return "cost=$cost, volume=$volume"
    }
}

class BlackTea(override val cost: Int, override val volume: Int) : Tea(cost, volume) {
    override fun toString(): String {
        return "BlackTea{cost=$cost, volume=$volume}"
    }
}
