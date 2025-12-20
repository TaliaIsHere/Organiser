package app.allulith.tasks.impl.destinations.overview.ui

internal object Overview {
    data class UiState(
        val tasks: TasksStructure = TasksStructure.NoTasks,
    )

    sealed class TasksStructure {
        data object NoTasks : TasksStructure()
        data class Tasks(val tasks: List<Task>) : TasksStructure()
    }

    data class Task(
        val id: String,
        val title: String,
        val description: String?,
    )

    sealed class Event {
        data object NavigateToTaskCreation : Event()
        data object GoBack : Event()
        data class GoToTask(val id: String) : Event()
    }

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnAddTask : UiEvent()
        data class OnViewTask(val id: String) : UiEvent()
    }
}
