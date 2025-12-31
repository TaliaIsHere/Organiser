package app.allulith.tasks.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.tasks.api.destinations.TasksDestination
import app.allulith.tasks.impl.destinations.overview.ui.TasksOverviewRoute
import app.allulith.tasks.impl.destinations.taskCreation.ui.TaskCreationRoute

internal fun EntryProviderScope<NavKey>.tasksNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<TasksDestination.TasksOverview> {
        TasksOverviewRoute(backStack = backStack)
    }

    entry<TasksDestination.TaskCreation> {
        TaskCreationRoute(
            backStack = backStack,
            task = it.task,
        )
    }
}
