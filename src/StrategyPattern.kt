abstract class Animal {
    protected lateinit var flyBehaivor: Flyable
    protected lateinit var walkBehaivor: Walkable

    abstract fun breath()
    abstract fun name()

    fun fly() {
        flyBehaivor.fly()
    }

    fun walk() {
        walkBehaivor.walk()
    }
}

interface Flyable {
    fun fly()
}

interface Walkable {
    fun walk()
}

class MamelWalking : Walkable {
    override fun walk() {
        println("mamel walk !!! mio mio !!!")
    }
}

class SpeedyWalk : Walkable {
    override fun walk() {
        println("Speedy Walk !!!MOVE FAST MOVE FAST FAST !!!")
    }
}

class CantFly : Flyable {
    override fun fly() {
        println("I can't fly")
    }
}

class Pet : Animal() {

    init {
        walkBehaivor = MamelWalking()
        flyBehaivor = CantFly()
    }

    override fun breath() {
        println("BREATH")
    }

    override fun name() {
        println("PET")
    }

    fun setWalk(walkable: Walkable) {
        this.walkBehaivor = walkable
    }
}


fun main(args: Array<String>) {


    val pet = Pet()
    pet.fly()
    pet.walk()
    pet.setWalk(SpeedyWalk())
    pet.walk()
}