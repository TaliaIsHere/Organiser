package app.allulith.tasks.impl

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.allulith.tasks.api.destinations.TasksDestination
import app.allulith.tasks.impl.destinations.overview.ui.OverviewRoute
import app.allulith.tasks.impl.destinations.taskCreation.ui.TaskCreationRoute

internal fun EntryProviderScope<NavKey>.tasksNavigationBuilder(
    backStack: SnapshotStateList<NavKey>,
) {
    entry<TasksDestination.Overview> {
        OverviewRoute(
            goBack = { backStack.removeLastOrNull() },
            navigateToTaskCreation = { task ->
                backStack.add(TasksDestination.TaskCreation(task = task))
            },
        )
    }

    entry<TasksDestination.TaskCreation> {
        TaskCreationRoute(
            task = it.task,
            goBack = { backStack.removeLastOrNull() },
        )
    }
}
