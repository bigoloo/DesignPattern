object Singleton {
    init {
        println("Initializing with object: $this")
    }

    fun print() = println("Printing with object: $this")
}

fun main(args: Array<String>) {
    val firstReference = Singleton
    val secondReference = Singleton

    firstReference.print()
    secondReference.print()

}