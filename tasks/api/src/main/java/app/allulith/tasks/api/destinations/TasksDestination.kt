package app.allulith.tasks.api.destinations

import androidx.navigation3.runtime.NavKey

sealed class TasksDestination : NavKey {
    data object Overview : TasksDestination()
    data object TaskCreation : TasksDestination()
    data class TaskDetail(val id: String) : TasksDestination()
}
