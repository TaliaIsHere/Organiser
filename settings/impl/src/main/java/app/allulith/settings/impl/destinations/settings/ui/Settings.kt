package app.allulith.settings.impl.destinations.settings.ui

internal object Settings {

    data class UiState(
        val version: String = "",
    )

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnDeleteAccount : UiEvent()
    }
}
