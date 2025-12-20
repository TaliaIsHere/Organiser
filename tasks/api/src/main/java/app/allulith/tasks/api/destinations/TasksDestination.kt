package app.allulith.tasks.api.destinations

import androidx.navigation3.runtime.NavKey
import app.allulith.tasks.api.domain.Task

sealed class TasksDestination : NavKey {
    data object Overview : TasksDestination()
    data class TaskCreation(val task: Task?) : TasksDestination()
}
