package app.allulith.tasks.api.destinations.home.ui

import androidx.navigation3.runtime.NavKey

sealed class TasksDestination : NavKey {
    data object Overview : TasksDestination()
}
