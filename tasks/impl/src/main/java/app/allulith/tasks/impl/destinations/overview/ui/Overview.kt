package app.allulith.tasks.impl.destinations.overview.ui

internal object Overview {
    data class UiState(
        val tasks: TasksStructure = TasksStructure.NoTasks,
    )

    sealed class TasksStructure {
        data object NoTasks : TasksStructure()
        data class Tasks(val tasks: List<Any>) : TasksStructure()
    }

    sealed class Event {
        data object NavigateToTaskCreation : Event()
        data object GoBack : Event()
    }

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnAddTask : UiEvent()
    }
}
