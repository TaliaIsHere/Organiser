package app.allulith.settings.impl.destinations.settings.ui

internal object Settings {

    data class UiState(
        val version: String = "",
    )

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnDeleteAccount : UiEvent()
    }

    sealed class Event {
        data object GoBack : Event()
        data object NavigateToRouting : Event()
    }
}
