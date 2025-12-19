package app.allulith.home.impl.destinations.home.ui

internal object Home {

    data class UiState(
        val name: String = "",
    )

    sealed class UiEvent {
        data object OnSettingsTap : UiEvent()
        data object OnTasksTap : UiEvent()
        data object OnGoalsTap : UiEvent()
        data object OnRemindersTap : UiEvent()
    }

    sealed class Event {
        data object NavigateToSettings : Event()
        data object NavigateToTasks : Event()
    }
}
