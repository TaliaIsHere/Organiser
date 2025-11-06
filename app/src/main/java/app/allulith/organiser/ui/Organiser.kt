package app.allulith.organiser.ui

internal object Organiser {

    sealed class UiState {
        data object Loading : UiState()
        data class Data(val startRoute: Any) : UiState()
    }
}
