package app.allulith.tasks.impl.destinations.overview.ui

import app.allulith.tasks.api.domain.Task

internal object Overview {
    data class UiState(
        val tasks: TasksStructure = TasksStructure.NoTasks,
    )

    sealed class TasksStructure {
        data object NoTasks : TasksStructure()
        data class Tasks(val tasks: List<Task>) : TasksStructure()
    }

    sealed class Event {
        data class NavigateToTaskCreation(val task: Task?) : Event()
        data object GoBack : Event()
    }

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnAddTask : UiEvent()
        data class OnViewTask(val task: Task) : UiEvent()
    }
}
