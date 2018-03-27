interface Helicopter {
    fun slowFly()
}

interface Airplane {
    fun fly()
}

class Apache : Helicopter {
    override fun slowFly() {
        println("Apache fly")
    }

}

class Boeing(private val helicopter: Helicopter) : Airplane {

    override fun fly() {
        println("Boeing fly")
        helicopter.slowFly()
    }

}

fun main(args: Array<String>) {


    val helicopter: Helicopter = Apache()
    val airPlane: Airplane = Boeing(helicopter)
    airPlane.fly()
}