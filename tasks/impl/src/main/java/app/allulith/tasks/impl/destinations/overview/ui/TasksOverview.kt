package app.allulith.tasks.impl.destinations.overview.ui

import androidx.compose.runtime.Stable
import app.allulith.tasks.api.domain.Task

internal object TasksOverview {
    data class UiState(
        val tasks: TasksStructure = TasksStructure.NoTasks,
    )

    sealed class TasksStructure {
        data object NoTasks : TasksStructure()

        @Stable
        data class Tasks(val tasks: List<Task>) : TasksStructure()
    }

    sealed class UiEvent {
        data object OnBack : UiEvent()
        data object OnAddTask : UiEvent()
        data class OnViewTask(val task: Task) : UiEvent()
    }
}
