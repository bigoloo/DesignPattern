interface House {
    var size: Int
    var name: String
}

class Village : House {
    override var size: Int = 1000

    override var name: String = "Village"
}

class Apartment : House {
    override var size: Int = 100
    override var name: String = "Apartment"
}


class HouseFactory {

    fun createHouse(type: String): House? {

        return when (type) {
            "Village" -> Village()
            "Apartment" -> Apartment()
            else -> null
        }
    }
}

fun main(args: Array<String>) {


    val village = HouseFactory().createHouse("Village")
    val apartment = HouseFactory().createHouse("Apartment")

    println("name:${village?.name} ,size: ${village?.size}")
    println("name:${apartment?.name} ,size: ${apartment?.size}")
}