fun execute(task: () -> Unit) {
    println("before calling method ${System.currentTimeMillis()}")

    task()
    println("after calling method ${System.currentTimeMillis()}")


}

fun main(args: Array<String>) {
    execute {

        println("Running execute function ")
    }
}