abstract class Car {
    abstract fun name(): String
    abstract fun cost(): Double
}

abstract class AdditionalDecorator : Car()

class Porsche : Car() {
    override fun name(): String {
        return "Porsche"
    }

    override fun cost(): Double {
        return 1000.0
    }

}

class BMW : Car() {
    override fun name(): String {
        return "BMW"
    }

    override fun cost(): Double {
        return 500.0
    }
}

class TurboCar(private var car: Car) : AdditionalDecorator() {

    override fun name(): String {

        return "Torbo: " + car.name()
    }

    override fun cost(): Double {
        return 2 + car.cost()
    }

}

class ColoredCar(private var car: Car) : AdditionalDecorator() {

    override fun name(): String {

        return "ColoredCar: " + car.name()
    }

    override fun cost(): Double {
        return 1 + car.cost()
    }

}


fun main(args: Array<String>) {


    var car: Car = BMW()
    car = TurboCar(car)
    car = ColoredCar(car)
    println("cost: ${car.cost()}")
    println("name: ${car.name()}")
    val car1 = ColoredCar(TurboCar(Porsche()))
    println("cost: ${car1.cost()}")
    println("name: ${car1.name()}")
}
