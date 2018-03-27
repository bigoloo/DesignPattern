abstract class Observer {
    abstract fun update(message: String?)
}

interface Subject {

    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class Publisher : Subject {
    val observerList: ArrayList<Observer> = ArrayList()

    override fun removeObserver(observer: Observer) {
        observerList.remove(observer)
    }

    var currentMessage: String? = null

    fun setMessage(message: String) {
        currentMessage = message
        notifyObservers()
    }

    override fun notifyObservers() {

        observerList.forEach { observer ->
            observer.update(currentMessage)
        }

    }

    override fun registerObserver(observer: Observer) {
        observerList.add(observer)
    }


}
class Subscriber: Observer() {
    override fun update(message: String?) {
        println("observerName is: $this ,message is $message")
    }

}

fun main(args: Array<String>) {
    val publisher = Publisher()
    val observer1 = Subscriber()
    val observer2 = Subscriber()
    val observer3 = Subscriber()
    publisher.registerObserver(observer1)
    publisher.registerObserver(observer2)
    publisher.registerObserver(observer3)
    publisher.setMessage("Hi ")
    publisher.removeObserver(observer2)
    publisher.setMessage("how are u ")

}