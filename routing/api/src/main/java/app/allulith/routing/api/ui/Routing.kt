package app.allulith.routing.api.ui

object Routing {

    sealed class Event {
        data object NavigateToHome : Event()
        data object NavigateToSignUp : Event()
    }
}
