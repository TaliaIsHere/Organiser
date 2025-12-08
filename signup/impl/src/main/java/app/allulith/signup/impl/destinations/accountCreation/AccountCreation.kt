package app.allulith.signup.impl.destinations.accountCreation

internal object AccountCreation {

    data class UiState(
        val name: String = "",
        val error: Boolean = false,
    )

    sealed class UiEvent {
        data class OnNameChange(val text: String) : UiEvent()
        data object OnCreateAccountTap : UiEvent()
    }

    sealed class Event {
        data object NavigateToHome : Event()
    }
}
