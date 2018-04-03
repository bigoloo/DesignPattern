sealed class State
class UnAuthorized : State()
class Authorized(val userName: String) : State()

class AuthorizationPresenter {

    private var state: State = UnAuthorized()

    fun loginUser(userLogin: String) {
        state = Authorized(userLogin)
    }

    fun logoutUser() {
        state = UnAuthorized()
    }

    val isAuthorized: Boolean
        get() = when (state) {
            is Authorized -> true
            is UnAuthorized -> false
        }

    val userLogin: String
        get() = when (state) {
            is Authorized -> (state as Authorized).userName
            is UnAuthorized -> "Unknown"
        }

    override fun toString() = "User '$userLogin' is logged in: $isAuthorized"
}

fun main(args: Array<String>) {
    val authorization = AuthorizationPresenter()
    authorization.loginUser("admin")
    println(authorization)
    authorization.logoutUser()
    println(authorization)
}