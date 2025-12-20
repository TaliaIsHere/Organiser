package app.allulith.tasks.impl.destinations.taskCreation.ui

internal object TaskCreation {

    data class UiState(
        val taskTitle: String = "",
        val taskDescription: String = "",
        val taskTitleError: Boolean = false,
    )

    sealed class UiEvent {
        data class OnTitleChange(val text: String) : UiEvent()
        data class OnDescriptionChange(val text: String) : UiEvent()
        data object OnCreateTaskTap : UiEvent()
        data object OnBackTap : UiEvent()
    }

    sealed class Event {
        data object GoBack : Event()
    }
}
