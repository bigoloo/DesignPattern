open class Component {

    open fun add(c: Component) {
    }

    open fun remove(c: Component) {
    }

    open fun getChild(n: Int): Component {
        throw UnsupportedOperationException("getChild method not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun operation() {}

}

class Leaf(private var name: String) : Component() {

    override fun operation() {
        super.operation()
        println("name:$name")
    }
}
class Composite(s:String): Component() {

    var sName:String
    var aChildren:MutableList<Component>

    init {
        this.sName= s
        aChildren= mutableListOf()
    }

    override fun add(c: Component) {
        super.add(c)
        aChildren.add(c)
    }

    override fun remove(c: Component) {
        super.remove(c)
        aChildren.remove(c)
    }

    override fun operation() {
        super.operation()
        println(this.sName)
        aChildren.forEach{
            it.operation()
        }
    }

}

fun main(args: Array<String>) {


     var composite=Composite("Root")
     var composite2=Composite("Composite Leaf")

    composite.add(Leaf("leaf 1 "))
    composite.add(Leaf("leaf 2 "))
    composite.add(Leaf("leaf 3 "))
    composite2.add(Leaf("leaf 1"))
    composite.add(composite2)
    composite.operation()
}