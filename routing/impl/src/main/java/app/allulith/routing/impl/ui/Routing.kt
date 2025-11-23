package app.allulith.routing.impl.ui

object Routing {

    sealed class Event {
        data object NavigateToHome : Event()
        data object NavigateToSignUp : Event()
    }
}
