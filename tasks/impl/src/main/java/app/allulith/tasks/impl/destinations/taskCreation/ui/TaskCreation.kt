package app.allulith.tasks.impl.destinations.taskCreation.ui

internal object TaskCreation {

    data class UiState(
        val taskTitle: String,
        val taskDescription: String,
        val taskTitleError: Boolean = false,
        val taskState: TaskState,
    )

    sealed class TaskState {
        data object Edit : TaskState()
        data object New : TaskState()
    }

    sealed class UiEvent {
        data class OnTitleChange(val text: String) : UiEvent()
        data class OnDescriptionChange(val text: String) : UiEvent()
        data object OnCreateTaskTap : UiEvent()
        data object OnUpdateTaskTap : UiEvent()
        data object OnBackTap : UiEvent()
        data object OnDeleteTap : UiEvent()
    }

    sealed class Event {
        data object GoBack : Event()
    }
}
