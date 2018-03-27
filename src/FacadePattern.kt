class ComplexDataSaver(private val path: String) {

    init {
        print("ComplexDataSaver -->$path")
    }

    private val store = HashMap<String, String>()
    fun store(key: String, value: String) {
        store.put(key, value)
    }

    fun read(key: String): String {
        println("Storing cached data: $store to file: $path")
        return store[key] ?: "Empty"
    }


}

data class Archive(val description: String)
class ArchiveManager {
    private val sharedPreference = ComplexDataSaver("/android/data/")

    fun archive(archive: Archive) {
        sharedPreference.store("archive", archive.description)
    }

    fun readFirst(): Archive {
        return Archive(sharedPreference.read("archive"))
    }

}

fun main(args: Array<String>) {
    val archiveManager = ArchiveManager()
    val archive = Archive("Archive Manager !!!!")
    archiveManager.archive(archive)

    println("restored Archive is ${archiveManager.readFirst().description}")

}