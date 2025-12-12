package app.allulith.routing.impl.routing.ui

internal object Routing {

    sealed class Event {
        data object NavigateToHome : Event()
        data object NavigateToSignUp : Event()
    }
}
